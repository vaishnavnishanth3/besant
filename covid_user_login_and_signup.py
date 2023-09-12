import covid_user_inputs
import mysql.connector
import random

covid_db=mysql.connector.connect(
    host="localhost",
    user="root",
    password="12345",
    database="covid_data"
) 
cursor=covid_db.cursor()

def user_sign_up():
    s_no=random.randint(0000,9999)
    name=input("Enter your name: ")
    age=input("Enter your age: ")
    gender=input("Enter your gender [M/F/Others]: ")
    mobile=int(input("Enter your Mobile: "))
    email=input("Enter your Email: ")
    username=input("Enter your Username: ")
    password=input("Enter your password: ")
    sql_insert_data="insert into login_database (S_No, Username, Password, Name, Age, Gender, Mobile, Email) values (%s,%s,%s,%s,%s,%s,%s,%s)"
    val=(s_no,username,password,name,age,gender,mobile,email)
    cursor.execute(sql_insert_data,val)
    covid_db.commit()
    print("")
    print("Sign Up Successfully")

def user_log_in():
    login_username=input("Enter your username: ")
    login_password=input("Enter your password: ")
    sql_login = "SELECT Password FROM login_database WHERE Username = %s"
    cursor.execute(sql_login, (login_username,))
    result = cursor.fetchone()
    if result is not None and result [0] == login_password :
        print("")
        print("Login Successfull")
    else:
        print("The Username / Password is invalid")
        user_log_in()
            
def user_action():
    print("")
    print("                                     [ Sign Up | Login ]")
    print("")
    print("Input 1 --> [ Sign-Up ]")
    print("Input 2 --> [ Login ]")
    print("")

    signin_option=int(input("Enter your option: "))

    if signin_option==1:
        print("")
        user_sign_up()
        print("")
        user_action()
    elif signin_option==2:
        print("")
        user_log_in()
        print("")
        covid_user_inputs.user_actions()
    else:
        print("Invalid input!")
        user_action()