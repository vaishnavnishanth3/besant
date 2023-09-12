import mysql.connector
import random

atm_machine=mysql.connector.connect(
    host="localhost",
    user="root",
    password="12345",
    database="atm_machine"
)
cursor=atm_machine.cursor()

def register_card():
    print("")
    s_no=random.randint(0,99)
    card_number=random.randint(0000000000000000,9999999999999999)
    account_type=input("Enter the Account Type: ")
    account_number=random.randint(00000000000,999999999999)
    pin=random.randint(0000,9999)
    name=input("Enter your name: ")
    email=input("Enter your email: ")
    mobile=int(input("Enter your Mobile Number: "))
    sql_register_card="insert into login_data (`S.No`,`Card Number`,`Account Type`,`Account Number`,Pin,Name,Email,Mobile) values (%s,%s,%s,%s,%s,%s,%s,%s)"
    vals=(s_no,card_number,account_type,account_number,pin,name,email,mobile)
    cursor.execute(sql_register_card,vals)
    atm_machine.commit()
    print("")
    print("Data Registered")
    print("")

def insert_account_info():
    import datetime
    print("")
    s_no=random.randint(0,99)
    account_number=input("Enter account number: ")
    pin=int(input("Enter the 4 digit pin: "))
    name=input("Enter Name: ")
    date_time=datetime.datetime.now()
    balance=input("Enter the First Deposit: ")
    last_transaction=datetime.datetime.now()
    sql_account_info="insert into account_details (`S.No`,`Account Number`,Pin,Name,`Account Created On (Date & Time)`,Balance,`Last Transaction`) values (%s,%s,%s,%s,%s,%s,%s)"
    vals=(s_no,account_number,pin,name,date_time,balance,last_transaction)
    cursor.execute(sql_account_info,vals)
    atm_machine.commit()
    print("")
    print("Account Info Inserted")
    print("")

def view_account_info():
    sql="select * from account_details"
    cursor.execute(sql)
    for data in cursor.fetchall():
        print(data)
    atm_machine.commit()

def view_user_info():
    sql="select * from login_data"
    cursor.execute(sql)
    for data in cursor.fetchall():
        print(data)
    atm_machine.commit()

def action():
    print("")
    print("[ Register User Info | View User Info | Register Account Info | View Account Info ]")
    print("")
    print("Input 1 --> Register User Info")
    print("Input 2 --> View User Info")
    print("Input 3 --> Register Account Info")
    print("Input 4 --> View Account Info")
    print("Input 5 --> Exit")
    print("")
    option=int(input("Enter your Option: "))
    if option==1:
        print("")
        register_card()
        print("")
        action()
    elif option==2:
        print("")
        view_user_info()
        print("")
        action()
    elif option==3:
        print("")
        insert_account_info()
        print("")
        action()
    elif option==4:
        print("")
        view_account_info()
        print("")
        action()
    elif option==5:
        print("")
        print("Logged-Out")
    else:
        print("")
        print("Invalid Input!")
        action()
action()