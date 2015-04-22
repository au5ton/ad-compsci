
const int pinCount = 6;
int pins [pinCount] =  {2,3,4,6,8,9}; 
int incoming = 0;

void resetPins()
{
  for(int i = 0; i < pinCount; i++)
  {
    digitalWrite(pins[i],LOW);
  }
}

void writeNPins(int n)
{
  for(int i = 0; i < n; i++)
  {
    digitalWrite(pins[i],HIGH);
    delay(100);
  }
}

void transition()
{
  int d = 25;
  for(int i = 0; i < pinCount; i++)
  {
    resetPins();
    digitalWrite(pins[i],HIGH);
    delay(d);
  }
  for(int i = pinCount; i > 0; i--)
  {
    resetPins();
    digitalWrite(pins[i],HIGH);
    delay(d);
  }
  resetPins();
}

void setup()
{
  Serial.begin(9600);
  randomSeed(analogRead(A0));
  for(int i = 0; i < pinCount; i++)
  {
    Serial.print("Pin ");
    Serial.print(pins[i]);
    Serial.println(" set as OUTPUT.");
    pinMode(pins[i],OUTPUT);
  }
}

void loop()
{
  int r = random(1,7);
  Serial.print("r: ");
  Serial.println(r);
  resetPins();
  transition();
  writeNPins(r);
  delay(2000);
}


