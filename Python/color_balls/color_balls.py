
# Create a dictionary to store balls
balls = {}

# Read input and store it in dictionary
line = input()
while line != "End":
    color, count = line.split(': ')
    balls[color] = int(count)
    line = input()

min_color = ""
min_count = float("inf")

# Find the smallest color group
for color, count in balls.items():
    if count < min_count:
        min_count = count
        min_color = color

# Take all balls except for the smallest color group
min_sum = 0
for color, count in balls.items():
    if color != min_color:
        min_sum += count

print(f"Minimum number of balls: {min_sum}")
