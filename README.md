ABOUT:
  Just a simple little program to track me and my buddies mario kart wii statistics while we play to see who is better on which course and
  who is luckier because i swear he is 10 times luckier than me.
  
ADDING NEW DATA:
  To add new race data click on "add new race record" button.
  
HOW TO USE:
  I programmed in java using swing so to launch this application you will need a code editor that can use java. I used eclipse which is free. If you want to track
  you're own data you will need to change all the numbers to 1's until you have played every course at least once because there is a divide by 0 error if you put the
  amount of times played value to 0.After you have played all the courses at least one time you can set all the numbers back by 1 to correctly display your correct 
  statistics.The useless at the end is needed because the file reading messes up without it. the player luck is up to the person inputing data
  and if you dont care about adding the luck just put 1 every time.
  
  Example format: CourseName,AmountOfTimesPlayed,P1Luck,P2Luck,P1Points,P2Points,useless
  CourseName = name of the course
  AmountOfTimesPlayed = amount of times played that course
  P1Luck = player 1 total luck on that course
  P2Luck = player 2 total luck on that course
  P1Points = player 1 total points on that course 
  P2Points = player 2 total points on that course 
  useless = just a useless variable there just for file reading to work properly
