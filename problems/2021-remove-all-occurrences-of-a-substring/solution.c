char* removeOccurrences(char* s, char* part) {
    int lenS = strlen(s);
    int lenPart = strlen(part);
    
    if (lenPart == 0 || lenS == 0) return s;

    char *pos;
    while ((pos = strstr(s, part)) != NULL) {  // Find the substring
        memmove(pos, pos + lenPart, strlen(pos + lenPart) + 1);  // Shift the remaining characters
    }
    return s;
}
