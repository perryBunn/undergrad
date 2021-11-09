import java.net.*; // for InetAddress
import java.util.Arrays;
import java.util.Scanner;

public class MyInetAddressExample {
    public static void main(String[] args) {
        // Get name and IP address of the local host
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Local Host:");
            System.out.println("\t" + address.getHostName());
            System.out.println("\t" + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unable to determine this host's address");
        }
        if (args.length == 0) {
            System.out.print("Please enter a host name: ");
            Scanner scan = new Scanner(System.in);
            String res = scan.nextLine();
            try {
                InetAddress address = InetAddress.getByName(res);
                System.out.println("\t" + address.getHostName());
                System.out.println("\t" + address.getHostAddress());
                String binary[] = addressConversion(address.getHostAddress());
                System.out.println("\t" + binary[0]);
                System.out.println("\t" + binary[1]);
            } catch (UnknownHostException e) {
                System.out.println("Unable to find address for " + res);
            }
        } else {
            for (int i = 0; i < args.length; i++) {
                // Get name(s)/address(es) o hosts given on command-line
                try {
                    InetAddress[] addressList = InetAddress.getAllByName(args[i]);
                    System.out.println(args[i] + ":");
                    // Print the first name. Assume array contains at least one entry.
                    System.out.println("\t" + addressList[0].getHostName());
                    for (int j = 0; j < addressList.length; j++) {
                        System.out.println("\t" + addressList[i].getHostAddress());
                        String binary[] = addressConversion(addressList[i].getHostAddress());
                        System.out.println("\t" + binary[0]);
                        System.out.println("\t" + binary[1]);
                    }
                } catch (UnknownHostException e) {
                    System.out.println("Unable to find address for " + args[i]);
                }
            }
        }
    }

    /**
     * This code could be more optimized but I dont care enough to spend the time, brute force ftw.
     * @param address string interpretation of IP address.
     * @return array of length 2 which contains the binary dotted-quad and binary formats.
     */
    public static String[] addressConversion(String address) {
        String res[] = new String[8];
        String parts[] = address.split("\\.|:");
        for (int i = 0; i < parts.length; i++) {
            int p = 0;
            if (parts.length > 4) {
                p = Integer.parseInt(parts[i], 16);
            } else {
                p = Integer.parseInt(parts[i], 10);
            }
            String s = "";
            if (parts.length > 4) {
                if (p >= 32768) {
                    p -= 32768;
                    s += "1";
                } else {
                    s += "0";
                } if (p >= 16384) {
                    p -= 16384;
                    s += "1";
                } else {
                    s += "0";
                } if (p >= 8192) {
                    p -= 8192;
                    s += "1";
                } else {
                    s += "0";
                } if (p >= 4096) {
                    p -= 4096;
                    s += "1";
                } else {
                    s += "0";
                } if (p >= 2048) {
                    p -= 2048;
                    s += "1";
                } else {
                    s += "0";
                } if (p >= 1024) {
                    p -= 1024;
                    s += "1";
                } else {
                    s += "0";
                } if (p >= 512) {
                    p -= 512;
                    s += "1";
                } else {
                    s += "0";
                } if (p >= 256) {
                    p -= 256;
                    s += "1";
                } else {
                    s += "0";
                }
            }
            if (p >= 128) {
                    p -= 128;
                    s += "1";
            } else {
                    s += "0";
            } if (p >= 64) {
                    p -= 64;
                    s += "1";
            }  else {
                    s += "0";
            } if (p >= 32) {
                    p -= 32;
                    s += "1";
            }  else {
                    s += "0";
            } if (p >= 16) {
                    p -= 16;
                    s += "1";
            }  else {
                    s += "0";
            } if (p >= 8) {
                    p -= 8;
                    s += "1";
            }  else {
                    s += "0";
            } if (p >= 4) {
                    p -= 4;
                    s += "1";
            } else {
                    s += "0";
            } if (p >= 2) {
                    p -= 2;
                    s += "1";
            }  else {
                    s += "0";
            } if (p >= 1) {
                    p -= 1;
                    s += "1";
            }  else {
                    s += "0";
            }
            parts[i] = s;
        }
        if (parts.length > 4) {
            res[0] = parts[0] + "." + parts[1] + "." + parts[2] + "." + parts[3] + "." + parts[4] + "." + parts[5] + "." + parts[6] + "." + parts[7];
            res[1] = parts[0] + parts[1] + parts[2] + parts[3] + parts[4] + parts[5] + parts[6] + parts[7];
        } else {
            res[0] = parts[0] + "." + parts[1] + "." + parts[2] + "." + parts[3];
            res[1] = parts[0] + parts[1] + parts[2] + parts[3];

        }
        return res;
    }
}

