

const int p = 7;
int pins [p] = {2,3,4,6,8,9,11};
int d = 50;

void setup()
{
  Serial.begin(9600);
  randomSeed(analogRead(10));
  for(int i = 0; i < p; i++)
  {
    pinMode(pins[i],OUTPUT);
  }
}

void loop()
{
  int currentPin = random(0,p);
  Serial.print("currentPin: ");
  Serial.println(currentPin);
  digitalWrite(pins[currentPin],HIGH);
  delay(d);
  digitalWrite(pins[currentPin],LOW);
  //delay(d);
}
