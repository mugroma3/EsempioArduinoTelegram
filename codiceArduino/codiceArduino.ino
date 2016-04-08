int ledPin = 13;
int greenPin = 5;
int yellowPin = 6;
int redPin = 7;
boolean red = false;
boolean green = false;
boolean yellow = false;

void setup() {
  Serial.begin(9600);
  // put your setup code here, to run once:
  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(yellowPin, OUTPUT);
  digitalWrite(redPin, LOW);
  digitalWrite(greenPin, LOW);
  digitalWrite(yellowPin, LOW);
}

void loop() {
  if (Serial.available())
  {
    String s = Serial.readStringUntil('\n');

    if (Contains(s,"R"))
      red = !red;
    if (Contains(s,"G"))
      green = !green;
    if (Contains(s,"Y"))
      yellow = !yellow;
  }

if(red)
   digitalWrite(redPin, HIGH);
else
   digitalWrite(redPin, LOW);
   
if(green)
   digitalWrite(greenPin, HIGH);
else
   digitalWrite(greenPin, LOW);
   
if(yellow)
   digitalWrite(yellowPin, HIGH);
else
   digitalWrite(yellowPin, LOW);
  
  delay(40);
}



bool Contains(String s, String search) {
    int max = s.length() - search.length();

    for (int i = 0; i <= max; i++) {
        if (s.substring(i) == search) return true; // or i
    }

    return false; //or -1
} 
