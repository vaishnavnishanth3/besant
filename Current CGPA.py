print("")

#Sem Score Sums:
s1ssum=191 # Arrears - 0
s2ssum=225 # Arrears - 0 
s3ssum=191 # Arrears - 0 
s4ssum=179 # Arrears - 0 
s5ssum=151 # Arrears - 0 
s6ssum=142 # Arrears - 1 
s7ssum=0 # Arrears - 0
s8ssum=0 # Arrears - 0

totssum=s1ssum+s2ssum+s3ssum+s4ssum+s5ssum+s6ssum
print(f"Total Semester Scores Sum is {totssum}")

print("")
#Sem Credit Sums:
s1csum=25
s2csum=25
s3csum=23
s4csum=25
s5csum=22
s6csum=21
s7csum=22
s8csum=19

#arrear:
s6csum=18

totcsum=s1csum+s2csum+s3csum+s4csum+s5csum+s6csum
print(f"Total Semester Credits Sum is {totcsum}")


#All GPA:
gpa1=7.64
gpa2=9
gpa3=8.304
gpa4=7.16
gpa5=6.863
gpa6=7.888
gpa7=0
gpa8=0

print("")
#CGPA Calculations:
cgpa=totssum/totcsum
print(f"The CGPA is {cgpa}")

cur_cgpa=7.818
print("")
