import mysql.connector
import datetime

atm_machine=mysql.connector.connect(
    host="localhost",
    user="root",
    password="12345",
    database="atm_machine"
)
cursor=atm_machine.cursor()

def welcome():
    print("")
    print("WELCOME TO NATIONAL BANK ATM MACHINE")
    print("")
    print("Type ESC --> Stop the pending previous transaction and Insert Your Debit Card!")
    print("Type EXIT --> Exit the ATM Interface.")
    print("")
    option=input("Enter your Option: ")
    if option=="ESC":
        main_page()
    elif option=="EXIT":
        print("Thanks for using National BANK ATM")
    else:
        print("Invalid Input!")
        welcome()

def main_page():    
    print("")
    print("Insert Card: ")
    print("")
    print("Type YES --> if the card is inserted")
    print("")
    insert_option=input("Enter option: ")
    if insert_option=='YES':
        print("")
        print("Debit Card accepted!!")
        user()

def user():
    print("")
    print("[ Register for New Account | Use ATM by Debit Card ]")
    print("")
    print("Input 1 --> Registration")
    print("Input 2 --> Debit Card usage")
    print("Input 3 --> Exit to Main Page")
    print("")
    action_option=int(input("Enter your option: "))
    if action_option==1:
        print("")
        print("Visit nearby bank to create a new account & obtin Debit card")
        print("")
        welcome()
    elif action_option==2:
        print("")
        credentials()
    elif action_option==3:
        print("")
        welcome()
    else:
        print("Invalid Input")
        user()

def credentials():

    debit_card_number = input("Enter your Debit card number: ")
    debit_card_pin = input("Enter your Pin: ")
    sql_login = "SELECT Pin FROM login_data WHERE `Card Number` = %s"

    try:
        cursor.execute(sql_login, (debit_card_number,))
        result = cursor.fetchone()

        if result is not None and result[0] == debit_card_pin:
            print("")
            print("Credentials verified")
            user_action()
        else:
            print("Invalid credentials!!")
            credentials()

    except mysql.connector.Error as err:
        print(f"Error: {err}")

    finally:
        cursor.close()

def user_action():
    print("[ View Balance | Withdraw Money | Deposit Money ]")
    print("")
    print("Input 1 --> View Balance")
    print("Input 2 --> Withdraw Money")
    print("Input 3 --> Deposit Money")
    print("Input 4 --> Retrieve Card")
    print("")
    option=int(input("Enter Your Input: "))
    if option==1:
        print("")
        view_balance()
        print("")
        user_action()
    elif option==2:
        print("")
        withdraw_money()
        print("")
        user_action()
    elif option==3:
        print("")
        deposit_money()
        print("")
        user_action()
    elif option==4:
        print("")
        retrieve_card()
    else:
        print("Invalid Input!")
        user_action()

def view_balance():
    print("")
    account_number=input("Enter the Account Number: ")
    sql_view_balance="SELECT Balance FROM account_details where `Account Number` = %s"
    cursor.execute(sql_view_balance,(account_number,))
    for data in cursor.fetchall()[0]:
        print(f"your current balance is Rs.{data}")
    atm_machine.commit()

def withdraw_money():
    try:
        account_number = input("Enter the Account Number: ")
        debit_card_pin = input("Enter your Pin: ")

        sql_login = "SELECT Pin FROM login_data WHERE `Account Number` = %s"
        cursor.execute(sql_login, (account_number,))
        result = cursor.fetchone()

        if result is not None and result[0] == debit_card_pin:
            
            sql_view_balance = "SELECT Balance FROM account_details WHERE `Account Number` = %s"
            cursor.execute(sql_view_balance, (account_number,))
            current_balance = cursor.fetchone()[0]

            debit_amount = float(input("Enter the Amount to be Debited / Withdrawn: "))
            
            if int(debit_amount) > 0 and int(debit_amount) < int(current_balance):
                new_balance = int(current_balance) - int(debit_amount)
                date_time = datetime.datetime.now()

                sql_withdrawal_update = "UPDATE account_details SET Balance = %s , `Last Transaction` = %s WHERE `Account Number` = %s"
                cursor.execute(sql_withdrawal_update, (new_balance,date_time,account_number))
                atm_machine.commit()

                print("")
                print("Withdrawal Successful")
                print("")
                print(f"Amount Rs.{debit_amount} has been debited from your account {account_number} on {date_time}. Your Current Balance is {new_balance}")
                

            else:
                print("Your Balance is lower than your debit_amount. Please enter a valid amount.")
                withdraw_money()
        else:
            print("Invalid credentials!!")

    except mysql.connector.Error as err:
        print(f"Error: {err}")

    finally:
        cursor.close()

def deposit_money():
    try:
        account_number = input("Enter the Account Number: ")
        debit_card_pin = input("Enter your Pin: ")

        sql_login = "SELECT Pin FROM login_data WHERE `Account Number` = %s"
        cursor.execute(sql_login, (account_number,))
        result = cursor.fetchone()

        if result is not None and result[0] == debit_card_pin:
            
            sql_view_balance = "SELECT Balance FROM account_details WHERE `Account Number` = %s"
            cursor.execute(sql_view_balance, (account_number,))
            current_balance = cursor.fetchone()[0]

            credit_amount = float(input("Enter the Amount to be Credited / Depostied: "))
            
            if int(credit_amount) > 0:
                new_balance = int(current_balance) + int(credit_amount)
                date_time = datetime.datetime.now()

                sql_withdrawal_update = "UPDATE account_details SET Balance = %s , `Last Transaction` = %s WHERE `Account Number` = %s"
                cursor.execute(sql_withdrawal_update, (new_balance, date_time, account_number))
                atm_machine.commit()

                print("")
                print("Deposit Successful")
                print("")
                print(f"Amount Rs.{credit_amount} has been Credited to your account {account_number} on {date_time}. Your Current Balance is {new_balance}")
                
            else:
                print("Invalid amount. Please enter a valid amount.")
                withdraw_money()
        else:
            print("Invalid credentials!!")

    except mysql.connector.Error as err:
        print(f"Error: {err}")

    finally:
        cursor.close()

def retrieve_card():
    print("")
    print("Card Retrieved!! Don't Forget to Collect the Card!")
    print("")
    welcome()