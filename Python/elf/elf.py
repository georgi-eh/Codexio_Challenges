first_word = input()
second_word = input()

dropped_letters = 0
for letter in first_word:
    if letter in second_word:
        second_word = second_word.replace(letter, "", 1)
        continue
    dropped_letters += 1

dropped_letters += len(second_word)
print(dropped_letters)
