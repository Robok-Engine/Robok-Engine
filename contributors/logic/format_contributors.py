import json
import sys

def format_contributors(input_file, output_file):
    with open(input_file, 'r') as infile:
        contributors = json.load(infile)

    with open(output_file, 'w') as outfile:
        outfile.write('| Contributor | Contributions |\n')
        outfile.write('| ------------ | -------------- |\n')
        for contributor in contributors:
            name = contributor['login']
            contributions = contributor['contributions']
            outfile.write(f'| {name} | {contributions} |\n')

if __name__ == "__main__":
    format_contributors('../contributors_github.json', '../contributors_table.md')
