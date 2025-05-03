import Hash.File;

import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        var file = new File("abacaba");
        System.out.println(file.containsSubstring("cac"));
        System.out.println(file.containsSubstring("bab"));
        System.out.println(file.containsSubstring("abacabaa"));




    }
}

/*
#include <iostream>
#include <vector>

void fillPows(std::vector<size_t>& powsForHash)
{
    size_t coeffHash = 10, divider = 1e9 + 7;
    powsForHash[0] = 1;
    for (size_t i = 1; i < powsForHash.size(); ++i)
    {
        powsForHash[i] = (powsForHash[i - 1] * coeffHash) % divider;
    }
}

void hashFile(const std::string& file, std::vector<size_t>& hashForFile, std::vector<size_t>& powsForHash)
{

    size_t coeffHash = 10, divider = 1e9 + 7;
    fillPows(powsForHash);
    for (size_t i = 1; i <= file.size(); ++i)
    {
        hashForFile[i] = (hashForFile[i - 1] * coeffHash + (file[i - 1] - 96)) % divider;
    }
}

size_t hashString(const std::string& string)
{
    size_t result = 0, coeffHash = 10, divider = 1e9 + 7;
    for (size_t i = 1; i <= string.size(); ++i)
    {
        result = (result * coeffHash + (string[i - 1] - 96)) % divider;
    }
    return result;
}

void searchStringInText(std::vector<size_t> hashForFile, std::vector<size_t> powsForHash, const size_t& hashQueryString, const size_t& lengthQueryString)
{
    size_t hashSubStringLeft, hashSubStringRight, hashSubString, divider = 1e9 + 7, countStringInFile = 0;
    std::vector <size_t> indices;
    for (size_t i = lengthQueryString; i < hashForFile.size(); ++i)
    {
        hashSubStringLeft = (hashForFile[i - lengthQueryString] * powsForHash[lengthQueryString]) % divider;
        hashSubStringRight = hashForFile[i];
        if (hashSubStringRight < hashSubStringLeft)
        {
            hashSubStringRight += divider;
        }
        hashSubString = hashSubStringRight - hashSubStringLeft;
        if (hashSubString == hashQueryString)
        {
            ++countStringInFile;
            indices.push_back(i - lengthQueryString);
        }
    }

    std::cout << countStringInFile << ' ';
    for (size_t i = 0; i < countStringInFile; ++i)
    {
        std::cout << indices[i] << ' ';
    }
    std::cout << '\n';

}

void queriesInText(std::vector<size_t> hashForFile, std::vector<size_t> powsForHash, size_t countQueries)
{
    std::string stringFromQuery;
    size_t hashForQueryString;
    for (size_t i = 0; i < countQueries; ++i)
    {
        std::cin >> stringFromQuery;
        hashForQueryString = hashString(stringFromQuery);
        searchStringInText(hashForFile, powsForHash, hashForQueryString, stringFromQuery.size());
    }
}

int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    std::string file;
    int countQueries;
    std::cin >> file >> countQueries;
    std::vector<size_t> hashForFile(file.size() + 1);
    std::vector<size_t> powsForHash(file.size() + 1);

    hashFile(file, hashForFile, powsForHash);
    queriesInText(hashForFile, powsForHash, countQueries);

    return 0;
}*/
