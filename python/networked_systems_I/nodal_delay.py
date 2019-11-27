#-------------------------------------------------------
# CM261 nodal delay (more realistic example)
# uaing numbers from problem R18 page 68.
# note that the correct answer is d_prop which does not
# include d_tans. Sort of a trick question.
#-------------------------------------------------------
print("------------------------------------------------")
BITSPERBYTE = 8
L = 1000 * BITSPERBYTE #size of one 1000 Byte pkt in bits
BITSPERMEGABIT = 1000000     #bits in a Mbit
R = 2                  #transmission rate in Mbps per second


d_trans = (L/BITSPERMEGABIT)/R #convert to seconds
print("d_trans ==> {:#3.8F} seconds".format(d_trans))


#Here is the calculation in long form:
#2500km * 10**3 m/km = 2.5 * 10**6m
#(2.5 * 10**6 m) / (2.5 * 10**8m) / sec
# = (2.5 * 10**6m) * (1sec / 2.5*10**8m)
# = 1/100 sec or 0.01 sec
d = 2500 #km
metersPerKm = 1000
s = 2.5 * 10**8 #meters per second link speed
d_prop = (d * metersPerKm) / s
print("d_prop ==> {:#3.8F} seconds".format(d_prop))

d_nodal = d_trans + d_prop
print("d_nodal ==> {:#3.8F} seconds".format(d_nodal))
print("-----------------------------------------------")
#suppose we wanted to prompt for different parameters
L = int(input("How many bytes are in one packet? >"))
d = int(input("How long is the link in kilometers? >"))
R = float(input("What is the transmission rate at the router in Mbps? >"))
L = L * BITSPERBYTE
d_trans = (L/BITSPERMEGABIT)/R
print("d_trans ==> {:#3.8F} seconds".format(d_trans))
d_prop  = (d * metersPerKm) / s
print("d_prop ==> {:#3.8F} seconds".format(d_prop))
d_nodal = d_trans + d_prop
print("d_nodal ==> {:#3.8F} seconds".format(d_nodal))
    
