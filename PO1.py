# Create a function that, when given two positive integers a b, returns the string "a" if integer a took fewer steps to
# reach 1 than b when passed through the Collatz sequence, or "b" if integer b took fewer steps to reach 1 than a.

# Examples: collatz(10, 15) --> "a"
# Because 10.0 = 5.0 - 16.0 - 8.0 - 4.0 - 2.0 - 1.0: 6 steps and 15.0 = 17 steps
# collatz(13, 16) --> "b" and collatz(53782, 72534) --> "b"

def collatz_cal(num):
    cnt = 0
    while num != 1:
        cnt += 1
        if num % 2 == 0:
            num = (num // 2)
        elif num % 2 == 1:
            num = (3 * num + 1)
    return cnt

def collatz(a, b):
    if (collatz_cal(a)) < (collatz_cal(b)):
        print('a')
    elif (collatz_cal(a)) > (collatz_cal(b)):
        print('b')
    else:
        print('neither')

# results below are: a, b, b
collatz(10, 15)
collatz(13, 16)
collatz(53782, 72534)
