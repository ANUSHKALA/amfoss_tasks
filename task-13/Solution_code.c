#define green 13
#define red 11
#define buzzer 10
//The sensor will give green light if the distance between your vehicle and the object in parking lot id more than 3m i.e there is no car in the lot
//The sensor will give green light if the distance between your vehicle and the object in parking lot id less than 3m and more than 1m
//Thr buzzer will ring if the distance between your vehicle and the object in parking lot id less than 1m
int inches = 0;
int cm = 0;
long readUltrasonicDistance(int triggerPin, int echoPin)
{
  pinMode(triggerPin, OUTPUT);  // Clear the trigger
  digitalWrite(triggerPin, LOW);
  delayMicroseconds(2);
  // Sets the trigger pin to HIGH state for 10 microseconds
  digitalWrite(triggerPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(triggerPin, LOW);
  pinMode(echoPin, INPUT);
  // Reads the echo pin, and returns the sound wave travel time in microseconds
  return pulseIn(echoPin, HIGH);
}
void setup()
{
  Serial.begin(9600);
  pinMode(green,OUTPUT);
  pinMode(red,OUTPUT);
  pinMode(buzzer,OUTPUT);
}
void loop()
{
  // measure the ping time in cm
  cm = 0.01723 * readUltrasonicDistance(7, 7);
  // convert to inches by dividing by 2.54
  inches = (cm / 2.54);
  Serial.print(inches);
  Serial.print("in, ");
  Serial.print(cm);
  Serial.println("cm");
  delay(100); // Wait for 100 millisecond(s)  
  if(cm>=201 && cm>=300)
  {
    digitalWrite(green,HIGH);
    delay(500);
    digitalWrite(green,LOW);
    delay(500);    
  }  
  else if(cm>100 && cm<300)
  {
    digitalWrite(red,HIGH);
    delay(500);
    digitalWrite(red,LOW);
    delay(500); 
  }  
  else if(cm<=100)
  {
    digitalWrite(buzzer,HIGH);
    delay(500);
    digitalWrite(buzzer,LOW);
    delay(500); 
  }  
}
