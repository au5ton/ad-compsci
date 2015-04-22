#define DATA 10
#define CLOCK 9
#define LATCH 6

void setup()
{
  Serial.begin(9600);
  randomSeed(analogRead(A0));
  pinMode(DATA,OUTPUT);
  pinMode(LATCH,OUTPUT);
  pinMode(CLOCK,OUTPUT);
}

void loop()
{
  digitalWrite(LATCH,LOW);
  shiftOut(DATA,CLOCK,MSBFIRST,B11111111);
  digitalWrite(LATCH,HIGH);
}
