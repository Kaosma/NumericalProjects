weekdays = ["Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"]

year = range(1583,10000)
month = range(1,13)
day = range(1, 33) 

year = (input("Year: "))

while not year.isdigit():
    print("Wrong, insert integer!")
    year = (input("Year: "))

year = int(year)

while year not in range(1583, 10000):
    print("Out of allowed range 1583-9999")
    year = int(input("Year: "))

month = input("Month: ")

while not month.isdigit():
    print("Wrong, insert integer!")
    month = int(input("Month: "))

month = int(month)

while month not in range(1, 13):
    print("Out of allowed range 1-12")
    month = int(input("Month: "))

if month == 1 or month == 2:
    month += 12
    year -= 1

if month == 4 or month == 6 or month == 9 or month == 11:
    print("Jag är ovanlig månad")
    day = input("Date: ")
    
    while not day.isdigit():
        print("Wrong, insert integer")
        day = input("Date: ")

    day = int(day)
        
    while day not in range(1, 31):
        print("Out of allowed range 1-30")
        day = input("Date: ")
        day = int(day)

elif month == 14:
    print("Jag är februari")
    day = input("Date: ")
    
    while not day.isdigit ():
        print("Wrong, insert integer!")
        day = input("Date: ")

    day = int(day)
    
    if (year+1) % 400 == 0: 
        print("Jag är skottår")

        while day not in range(1, 30):
            print("Out of allowed range 1-29")
            day = input("Date: ")
            day = int(day)

    elif (year+1) % 4 == 0 and (year+1) % 100 != 0:
        print("Jag är skottår åååhhhhh")
        day = int(day)
        
        while day not in range(1, 30):
            print("Out of allowed range 1-29")
            day = input("Date: ")
            day = int(day)
            
    else:
        print("Jag är INTE skottår")
        day = int(day)

        while day not in range(1, 29):
            print("Out of allowed range 1-28")
            day = input("Date: ")
            day = int(day)

else:
    print("Jag är en vanlig månad")
    day = input("Date: ")
    day = int(day)

    while day not in range(1, 32):
        print("Out of allowed range 1-31")
        day = input("Date: ")
        day = int(day)
        
weekday = (day + 13*(month+1)//5 + year + year// 4 - year//100 + year//400) %7

print("It's a", weekdays[weekday]+"!")

