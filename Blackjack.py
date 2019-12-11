import random
import time

numberlist = [2, 3, 4, 5, 6, 7, 8, 9, 10, "J", "Q", "K", "A"]

deck = []
player = []
dealer = []

for i in range(5):             
    for i in numberlist:
        deck.append(str(i)+"♠")
        deck.append(str(i)+"♥")
        deck.append(str(i)+"♣")
        deck.append(str(i)+"♦")

random.shuffle(deck)

play = input("Do you want to play Blackjack? (yes/no)")

while play != "yes" and play != "no":
    print()
    print("Invalid option!")
    print()
    play = input("Do you want to play Blackjack? (yes/no)")
    print()

if play == "no":
    print()

while play == "yes":
    del player[:]
    del dealer[:]
    player_count = 0
    print()
    for i in range(2):
        player.append(deck[0])
        del deck[0]

    print("Player: " + ''.join([item+" " for item in player]))
    print()

    for i in player:
        if(i == 'K♦' or i == 'K♣' or i == 'K♥' or i == 'K♠' or i == 'Q♦' or i == 'Q♣' or i == 'Q♥' or i == 'Q♠' or i == 'J♦' or i == 'J♣' or i == 'J♥' or i == 'J♠'):
            player_count += 10

        elif i == 'A♦' or i == 'A♣' or i == 'A♥' or i == 'A♠':
            player_count += 11
                
        for j in numberlist[:9]:
            if (i == (str(j)+"♠") or i == (str(j)+"♥") or i == (str(j)+"♣") or i == (str(j)+"♦")):
                player_count += j

    while player_count < 21:
        answer = input("Choose your option ('hit', 'stay')")
        
        while answer != "hit" and answer != "stay":
            print()
            print("Invalid option!")
            print()
            answer = input("Choose your option ('hit', 'stay')")
        print()
        
        if answer == "stay":
            player_count = 0
            for i in player:
                if(i == 'K♦' or i == 'K♣' or i == 'K♥' or i == 'K♠' or i == 'Q♦' or i == 'Q♣' or i == 'Q♥' or i == 'Q♠' or i == 'J♦' or i == 'J♣' or i == 'J♥' or i == 'J♠'):
                    player_count += 10

                if i == 'A♦' or i == 'A♣' or i == 'A♥' or i == 'A♠':
                    player_count += 11
                
                for j in numberlist[:9]:
                    if (i == (str(j)+"♠") or i == (str(j)+"♥") or i == (str(j)+"♣") or i == (str(j)+"♦")):
                        player_count += j
                        
            print("You have: " + str(player_count))
            print()
            
            for i in range(2):
                time.sleep(3)
                dealer.append(deck[0])
                del deck[0]

                print("Dealer: " + ''.join([item+" " for item in dealer]))
                print()

            dealer_count = 0

            for i in dealer:
                if(i == 'K♦' or i == 'K♣' or i == 'K♥' or i == 'K♠' or i == 'Q♦' or i == 'Q♣' or i == 'Q♥' or i == 'Q♠' or i == 'J♦' or i == 'J♣' or i == 'J♥' or i == 'J♠'):
                    dealer_count += 10
                        
                if i == 'A♦' or i == 'A♣' or i == 'A♥' or i == 'A♠':
                    dealer_count += 11
                
                for j in numberlist[:9]:
                    if (i == (str(j)+"♠") or i == (str(j)+"♥") or i == (str(j)+"♣") or i == (str(j)+"♦")):
                        dealer_count += j
                        
            while dealer_count < player_count and dealer_count < 21:
                time.sleep(3)
                dealer.append(deck[0])
                del deck[0]
                print("Dealer: " + ''.join([item+" " for item in dealer]))
                print()

                dealer_count = 0

                for i in dealer:
                    if(i == 'K♦' or i == 'K♣' or i == 'K♥' or i == 'K♠' or i == 'Q♦' or i == 'Q♣' or i == 'Q♥' or i == 'Q♠' or i == 'J♦' or i == 'J♣' or i == 'J♥' or i == 'J♠'):
                        dealer_count += 10

                    if i == 'A♦' or i == 'A♣' or i == 'A♥' or i == 'A♠':
                        dealer_count += 11
                
                    for j in numberlist[:9]:
                        if (i == (str(j)+"♠") or i == (str(j)+"♥") or i == (str(j)+"♣") or i == (str(j)+"♦")):
                            dealer_count += j

            if dealer_count == 21:
                print("Dealer: " + str(dealer_count))
                print()
                print("You lost, dealer has BlackJack!")
                print()
                play = input("Do you want to play again? (yes/no)")       

                while play != "yes" and play != "no":
                    print()
                    print("Invalid option!")
                    print()
                    play = input("Do you want to play again? (yes/no)")
                    print()
    
                if play == "no":
                    print()
                    print("Thank you for playing, goodbye!")
                    
            if dealer_count > 21:
                print("Dealer: " + str(dealer_count))
                print()
                print("You win, dealer busted out!")
                print()
                play = input("Do you want to play again? (yes/no)")

                while play != "yes" and play != "no":
                    print()
                    print("Invalid option!")
                    print()
                    play = input("Do you want to play again? (yes/no)")
                    print()
    
                if play == "no":
                    print()
                    print("Thank you for playing, goodbye!")
                        
            if dealer_count > player_count and dealer_count < 21:
                print("Dealer: " + str(dealer_count))
                print()
                print("You lose!")
                print()
                play = input("Do you want to play again? (yes/no)")

                while play != "yes" and play != "no":
                    print()
                    print("Invalid option!")
                    print()
                    play = input("Do you want to play again? (yes/no)")
                    print()
    
                if play == "no":
                    print()
                    print("Thank you for playing, goodbye!")
                        
            if dealer_count == player_count:
                print("Dealer: " + str(dealer_count))
                print()
                print("It's a tie!")
                print()
                play = input("Do you want to play again? (yes/no)")

                while play != "yes" and play != "no":
                    print()
                    print("Invalid option!")
                    print()
                    play = input("Do you want to play again? (yes/no)")
                    print()
    
                if play == "no":
                    print()
                    print("Thank you for playing, goodbye!")
            break
        
        if answer == "hit":
            player.append(deck[0])
            del deck[0]
            print("Player: " + ''.join([str(item)+" " for item in player]))
            print()

            player_count = 0
            
            for i in player:
                if(i == 'K♦' or i == 'K♣' or i == 'K♥' or i == 'K♠' or i == 'Q♦' or i == 'Q♣' or i == 'Q♥' or i == 'Q♠' or i == 'J♦' or i == 'J♣' or i == 'J♥' or i == 'J♠'):
                    player_count += 10

                if i == 'A♦' or i == 'A♣' or i == 'A♥' or i == 'A♠':
                    player_count += 11
                
                for j in numberlist[:9]:
                    if (i == (str(j)+"♠") or i == (str(j)+"♥") or i == (str(j)+"♣") or i == (str(j)+"♦")):
                        player_count += j
            
    if player_count == 21:
        print("You have: " + str(player_count))
        print()
        print("Congratulations, you have BlackJack!")
        print()
        for i in range(2):
            time.sleep(3)
            dealer.append(deck[0])
            del deck[0]

            print("Dealer: " + ''.join([item+" " for item in dealer]))
            print()

        dealer_count = 0

        for i in dealer:
            if(i == 'K♦' or i == 'K♣' or i == 'K♥' or i == 'K♠' or i == 'Q♦' or i == 'Q♣' or i == 'Q♥' or i == 'Q♠' or i == 'J♦' or i == 'J♣' or i == 'J♥' or i == 'J♠'):
                dealer_count += 10

            if i == 'A♦' or i == 'A♣' or i == 'A♥' or i == 'A♠':
                dealer_count += 11
                
            for j in numberlist[:9]:
                if (i == (str(j)+"♠") or i == (str(j)+"♥") or i == (str(j)+"♣") or i == (str(j)+"♦")):
                    dealer_count += j
                    
        while dealer_count < player_count and dealer_count < 21:
            time.sleep(3)
            dealer.append(deck[0])
            del deck[0]
            print("Dealer: " + ''.join([item+" " for item in dealer]))
            print()

            dealer_count = 0

            for i in dealer:
                if(i == 'K♦' or i == 'K♣' or i == 'K♥' or i == 'K♠' or i == 'Q♦' or i == 'Q♣' or i == 'Q♥' or i == 'Q♠' or i == 'J♦' or i == 'J♣' or i == 'J♥' or i == 'J♠'):
                    dealer_count += 10

                if i == 'A♦' or i == 'A♣' or i == 'A♥' or i == 'A♠':
                    dealer_count += 11
                
                for j in numberlist[:9]:
                    if (i == (str(j)+"♠") or i == (str(j)+"♥") or i == (str(j)+"♣") or i == (str(j)+"♦")):
                        dealer_count += j

            if dealer_count > 21:
                print("Dealer: " + str(dealer_count))
                print()
                print("You win, dealer busted out!")
                print()
                play = input("Do you want to play again? (yes/no)")

                while play != "yes" and play != "no":
                    print()
                    print("Invalid option!")
                    print()
                    play = input("Do you want to play again? (yes/no)")

                if play == "no":
                    print()
                    print("Thank you for playing, goodbye!")

        if dealer_count == 21:
            print("Dealer: " + str(dealer_count))
            print()
            print("It's a tie, dealer has BlackJack!")
            print()
            play = input("Do you want to play again? (yes/no)")

            while play != "yes" and play != "no":
                print()
                print("Invalid option!")
                print()
                play = input("Do you want to play again? (yes/no)")
                print()

            if play == "no":
                print()
                print("Thank you for playing, goodbye!")
        
    if player_count > 21:
        print("You have: " + str(player_count))
        print()
        print("You busted out... You lose!")
        print()
        play = input("Do you want to play again? (yes/no)")

        while play != "yes" and play != "no":
            print()
            print("Invalid option!")
            print()
            play = input("Do you want to play again? (yes/no)")
            print()

        if play == "no":
            print()
            print("Thank you for playing, goodbye!")
