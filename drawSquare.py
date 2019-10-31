import turtle
import math

def draw_square():

    window = turtle.Screen()
    window.bgcolor("red")
    
    micaela = turtle.Turtle()
    micaela.shape("arrow")
    micaela.color("yellow")
    micaela.speed(3)

    for i in range(1, 5):
        micaela.forward(100)
        micaela.right(90)
       

    window.exitonclick()

def draw_circle():

    window = turtle.Screen()
    window.bgcolor("red")
    
    victoria = turtle.Turtle()
    victoria.shape("arrow")
    victoria.color("black")
    victoria.circle(200)
    victoria.speed(2)

    window.exitonclick()

def draw_triangle():

    window = turtle.Screen()
    window.bgcolor("red")
    
    miranda = turtle.Turtle()
    miranda.shape("arrow")
    miranda.color("blue")
    miranda.speed(1)

    L1 = int(input("Please select the length for first side of your triangle: "))
    miranda.forward(L1)
    
    i = int(input("Please choose first deegrerotation in your triangle (less than 180 degrees): "))
    miranda.right(i)
    L2 = int(input("Please select the length for second side of your triangle: "))
    miranda.forward(L2)
    if L1 == L2:
        miranda.right(180-(i/2))
        L3 = (math.sin(math.radians(180-i))*L1)/(math.sin(math.radians(180-(i/2))))
        miranda.forward(L3)
    else:
        miranda.right(180 - math.degrees ((math.asin ( L1*math.sin  (math.radians(180-i)) ))     //    (( L1**2 + L2**2 - 2*L1*L2*math.cos(math.radians (180-i))) **(0.5))))            
        L3 = ((L1**2) + (L2**2) - (2*L1*L2*(math.cos(math.radians(180-i)))))**(0.5)
        miranda.forward(L3)
        
    window.exitonclick()

def draw_art():

    window = turtle.Screen()
    window.bgcolor("red")
    erik = turtle.Turtle()
    erik.shape("arrow")
    erik.color("yellow")
    erik.speed(4)

    max_turn = 360
    total_turn = 0

    for i in range(1, 37):
        for i in range(1, 5):
            erik.forward(200)
            erik.right(90)
        erik.right(10)
    
#draw_circle()

#draw_square()

#draw_triangle()

draw_art()


    
