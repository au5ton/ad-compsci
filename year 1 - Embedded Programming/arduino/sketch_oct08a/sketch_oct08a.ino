void setup()
{
  pinMode(11,OUTPUT);
}

int range = 255;

void dot()
{
  analogWrite(11,100);
  delay(500);
  analogWrite(11,0);
  delay(500);
}
void dash()
{
  analogWrite(11,100);
  delay(1000);
  analogWrite(11,0);
  delay(1000);
}

void loop()
{
  
  dot();
  dot();
  dot();
  dot();
  
  dot();
  
  dash();
  dot();
  dot();
  dot();
  dot();
  dash();
  
  dash();
  dash();
  
  dot();
  dash();
  
  dash();
  dot();
  
  
  
}


