"""
Designed to read all the .ipynb files in a directory and make respective .py files for each.
"""
import json
import os
import hashlib
import csv
import traceback


def writefile(file_list, hash_list):
    try:
        with open('check.csv', 'w', newline='\n') as csv_file:
            writer = csv.writer(csv_file, delimiter=' ', quotechar='|', quoting=csv.QUOTE_MINIMAL)
            for i in range(len(file_list)):
                writer.writerow([file_list[i]] + [hash_list[i]])
    except ValueError:
        traceback.print_exc()


def readfile():
    try:
        output = []
        with open('check.csv', newline='\n') as csv_file:
            reader = csv.reader(csv_file, delimiter=' ',  quotechar='|', quoting=csv.QUOTE_MINIMAL)
            for row in reader:
                output.append(row)
        return output
    except ValueError:
        traceback.print_exc()


def writecode(filename, codestring):
    try:
        pythonfile = filename[:-6]+".py"
        with open(pythonfile, 'w') as writer:
            writer.write(codestring)
    except BaseException:
        traceback.print_exc()


def extractcode(filename):
    notebook = ''
    try:
        with open(filename, 'r', encoding='utf-8') as f:
            notebook = json.load(f)
        codeString = ''
        for cell in notebook['cells']:
            for line in cell['source']:
                codeString += line
            codeString += "\n\n"
            # print(codeString, '\n')
            writecode(filename, codeString)
    except BaseException:
        traceback.print_exc()


def hash(file):
    block_size = 65536
    hasher = hashlib.sha1()
    with open(file, "rb") as open_file:
        buf = open_file.read(block_size)
        while len(buf) > 0:
            hasher.update(buf)
            buf = open_file.read(block_size)
    return hasher.hexdigest()


def main(directory=""):
    path = "./"
    if directory != "":
        path = directory
    files = os.listdir(path)
    hash_list = []
    file_list = []
    for f in files:
        file_extension = f[-6:]
        if file_extension == ".ipynb":
            hashcode = hash(f)
            file_list.append(f)
            hash_list.append(hashcode)
            print(f, hashcode)
        else:
            print(f)
    obj = readfile()
    for row in obj:
        if not hash_list.__contains__(row[1]):
            print("File has changed. Updating %s.py..." % (row[0][:-6]))
            extractcode(row[0])
            writefile(file_list, hash_list)


if __name__ == '__main__':
    main()
