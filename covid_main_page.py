import covid_admin_log_in
import covid_admin_inputs
import covid_user_login_and_signup
import covid_user_inputs

def mainpage():
    print("")
    print("                        COVID INFORMATION DATABASE")
    print("")
    print("                         [ Admin | User | Exit ]")
    print("")
    print("Input 1 --> [ Admin ]")
    print("Input 2 --> [ User ]")
    print("Input 3 --> [ Close the Application ]")
    print("")

    access_option=int(input(("Enter your option: ")))
    if access_option==1:
        covid_admin_log_in.admin_login()
        covid_admin_inputs.admin_actions()

    elif access_option==2:
        covid_user_login_and_signup.user_action()
        covid_user_inputs.user_actions()

    elif access_option==3:
        print("Thank you for using this application.")
        print("")
    else:
        print("Invalid Input!!")
        mainpage()