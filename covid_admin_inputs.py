import covid_main_page
import mysql.connector
import random
import smtplib

covid_db=mysql.connector.connect(
    host="localhost",
    user="root",
    password="12345",
    database="covid_data"
) 
cursor=covid_db.cursor()

def view_appointment_schedule():
    sql_view_login_db="SELECT * FROM appointment_registration;"
    cursor.execute(sql_view_login_db,)
    for data in cursor.fetchall():
        print(data)
    covid_db.commit()
    print("")

def view_login_data():
    sql_view_login_db="SELECT * FROM login_database;"
    cursor.execute(sql_view_login_db,)
    for data in cursor.fetchall():
        print(data)
    covid_db.commit()
    print("")

def view_medical_data():
    sql_view_medical_data="SELECT * FROM medical_database;"
    cursor.execute(sql_view_medical_data,)
    for data in cursor.fetchall():
        print(data)
    covid_db.commit()
    print("")

def view_active_cases():
    sql_view_active="SELECT * FROM medical_database where `Test Result` = 'POSITIVE' ;"
    cursor.execute(sql_view_active,)
    for data in cursor.fetchall():
        print(data)
    covid_db.commit()
    print("")

def view_vaccination_details():
    sql_view_vaccine="SELECT * FROM vaccination_data"
    cursor.execute(sql_view_vaccine,)
    for data in cursor.fetchall():
        print(data)
    covid_db.commit()
    print("")

def view_death_details():
    sql_view_vaccine="SELECT * FROM death_details"
    cursor.execute(sql_view_vaccine,)
    for data in cursor.fetchall():
        print(data)
    covid_db.commit()
    print("")

def insert_medical_data():
    s_no=random.randint(00,99)
    name=input("Enter Patient Name: ")
    age=input("Enter Patient Age: ")
    testtype=input("Enter the Test type: ")
    testdate=input("Enter the Date of test: ")
    doneby=input("Test Done by: ")
    result=input("Test Result: ").upper()
    amount=input("Enter the Amount paid: Rs.")
    sql_insert="insert into medical_database (S_no,Name,Age,`Test Type`,`Test Date`,`Test Done by`,`Test Result`,`Amount paid for Test`) values (%s,%s,%s,%s,%s,%s,%s,%s)"
    val=(s_no,name,age,testtype,testdate,doneby,result,amount)
    cursor.execute(sql_insert,val)
    covid_db.commit()
    print("")
    print("Data Inserted!!")
    print("")

def insert_vaccination_data():
    s_no=random.randint(00,99)
    name=input("Enter Patient Name: ")
    age=input("Enter Patient Age: ")
    vaccination_status=input("Enter your Vaccination Status: ")
    vaccination_name=input("Enter Vaccine Name: ")
    vaccination_date=input("Enter Vaccination Date: ")
    payment=input("Enter payment method: ")
    sql_vaccination_data="insert into vaccination_data (S_no,Name,Age,`Vaccination Status`,`Vaccine Name`,`Vaccination Date`,`Payment for vaccine`) values (%s,%s,%s,%s,%s,%s,%s)"
    val=(s_no,name,age,vaccination_status,vaccination_name,vaccination_date,payment)
    cursor.execute(sql_vaccination_data,val)
    covid_db.commit()
    print("")
    print("Data Inserted!!")
    print("")

def email_sending():
    login_maidid=input("Enter the Login Mail ID: ")
    login_mailid_password=input("Enter the login Mail Password: ")
    reciever_mailid=input("Enter the Reciever Id: ")
    message = input("Enter the Message to be sent: ")
    s = smtplib.SMTP('smtp.gmail.com', 587)
    s.starttls()
    s.login(login_maidid, login_mailid_password)
    s.sendmail(login_maidid, reciever_mailid , message)
    s.quit()
    print("")
    print("Email Sents!!")
    print("")

def insert_death_data():
    s_no=random.randint(00,99)
    name=input("Enter Name: ")
    age=input("Enter Age: ")
    gender=input("Enter Gender: ")
    death_date=input("Enter death date: ")
    death_time=input("Enter death time: ")
    vaccination_status=input("Enter the vaccination status: ")
    city=input("Enter the city: ")
    treatments_status=input("Enter the treatment Status: ")
    sql_death_data="insert into death_details (`S.No`,Name,Age,Gender,`Death Date`,`Death Time`,`Vaccination Status`,`City`,`Treatment Status`) values (%s,%s,%s,%s,%s,%s,%s,%s,%s)"
    val=(s_no,name,age,gender,death_date,death_time,vaccination_status,city,treatments_status)
    cursor.execute(sql_death_data,val)
    covid_db.commit()
    print("")
    print("Data Inserted!!")
    
def update_test_result():
    reference_value=input("Enter the Name: ")
    change_data=input("Modified Data: ")
    sql_update_result="update medical_database set `Test Result` = %s where Name = %s"
    val=(change_data,reference_value)
    cursor.execute(sql_update_result,val)
    covid_db.commit()
    print("")
    print("Data Updated!!")

def navigate_option_admin():
    print("[ Continue | Logout ]")
    print("")
    print("Input 1 --> Continue")
    print("Input 2 --> Logout")
    option1=int(input("Enter your input: "))
    if option1==1:
        admin_actions()
    if option1==2:
        covid_main_page.mainpage()
    else:
        navigate_option_admin()

def admin_actions():
    print("")
    print("[ View Appointment Schedule | View Login Data | View Medical Data | View Active Cases | View Vaccination Details | View Death detail ]")
    print("                      [ Insert Medical Data | Insert Vaccination Data | Insert Death Data | Update Test Result Data ]")
    print("                                                             [ Send Email ]")
    print("                                                               [ Log-out ]")
    print("")
    print("Input  1 --> View Appointment Schedule")
    print("Input  2 --> View Login Data")
    print("Input  3 --> View Medical Data")
    print("Input  4 --> View Active Cases")
    print("Input  5 --> View Vaccination Details")
    print("Input  6 --> View Death details")
    print("Input  7 --> Insert Medical Data")
    print("Input  8 --> Insert Vaccination Data")
    print("Input  9 --> Insert Death Data")
    print("Input 10 --> Update Test Result Data")
    print("Input 11 --> Send Email")
    print("Input 12 --> Log-out")
    print("")
    access_option_2=int(input("Enter the input: "))
    if access_option_2==1:
        print("")
        view_appointment_schedule()
        print("")
        navigate_option_admin()
    elif access_option_2==2:
        print("")
        view_login_data()
        print("")
        navigate_option_admin()
    elif access_option_2==3:
        print("")
        view_medical_data()
        print("")
        navigate_option_admin()
    elif access_option_2==4:
        print("")
        view_active_cases()
        print("")
        navigate_option_admin()
    elif access_option_2==5:
        print("")
        view_vaccination_details()
        print("")
        navigate_option_admin()
    elif access_option_2==6:
        print("")
        view_death_details()
        print("")
        navigate_option_admin()
    elif access_option_2==7:
        print("")
        insert_medical_data()
        print("")
        navigate_option_admin()
    elif access_option_2==8:
        print("")
        insert_vaccination_data()
        print("")
        navigate_option_admin()
    elif access_option_2==9:
        print("")
        insert_death_data()
        print("")
        navigate_option_admin()
    elif access_option_2==10:
        print("")
        update_test_result()
        print("")
        navigate_option_admin()
    elif access_option_2==11:
        print("")
        email_sending()
        print("")
        navigate_option_admin()
    elif access_option_2==12:
        print("Logged Out")
        covid_main_page.mainpage()
    else:
        print("Invalid inputs")
        print("")
        admin_actions()