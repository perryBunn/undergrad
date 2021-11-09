import pandas as pd
import matplotlib.pyplot as plt


def process_file(file_location):
    headers = {
        'server': [],
        'ip': [],
        'icmp_seq': [],
        'ttl': [],
        'time': []
    }
    df = pd.DataFrame(headers)
    with open(file_location) as reader:
        line = reader.readline()
        i = 0
        while line:
            i += 1
            words = line.split(' ')
            for word in words:
                if words[0] == '64' or word == 'bytes' or word == 'ms\n':
                    words.remove(word)
                if words.__contains__('from'): # for some reason it would skip over the previous check for this string??
                    words.remove('from')
                if words.__contains__('bytes'): # for some reason it would skip over the previous check for this string?
                    words.remove('bytes')
                if word.__contains__(':'):
                    words.insert(words.index(word), word.strip('(:)'))
                    words.remove(word)
                if word.__contains__('='):
                    pre = word
                    words.insert(words.index(pre), float(word[word.index('=')+1:]))
                    words.remove(pre)
            line = reader.readline()

            row = pd.Series(words, index=df.columns)
            df = df.append(row, ignore_index=True)

        try:
            with pd.ExcelWriter('results.xlsx') as writer:
                df.to_excel(writer)
        except PermissionError:
            print('Wasnt able to write to the Excel sheet, it may be open.')

        res = input('Do you want to generate a scatter plot of your results? (y/n)')
        if res == 'y':
            ax = df.sort_values('time', ascending=True).plot.scatter(x=1, y='time')
            plt.setp(ax.get_xticklabels(), rotation=30, horizontalalignment='right')
            plt.tight_layout()
            plt.show()


if __name__ == '__main__':
    file = 'G:/My Drive/_School/2021/COMP 4320/H1-pingres.txt'
    process_file(file)
