from zipfile import ZipFile


def main(file: str = 'file2zip.txt', zip_name: str = 'ProgrammingHW'):
    """Zips the files read from the input text file.

    file: default = 'file2zip.txt'
    zip_name: default = 'ProgrammingHW'
    """
    with open(file, 'r') as f:
        files = f.read().split(",")
    f.close()
    with ZipFile(f'{zip_name}.zip', 'w') as zFile:
        for i in range(len(files)):
            zFile.write(files[i].strip())
    zFile.close()


if __name__ == '__main__':
    main(zip_name='perrybunn-ProgrammingHW')
