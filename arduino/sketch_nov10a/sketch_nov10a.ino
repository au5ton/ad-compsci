#define DATA 6
#define LATCH 8
#define CLOCK 10
#define ALL B11111111
#define NONE B00000000

int digits[] = {3,159,37,13,153,73,65,31,1,25};

void setup()
{
  Serial.begin(9600);
  randomSeed(analogRead(A0));
  pinMode(DATA,OUTPUT);
  pinMode(LATCH,OUTPUT);
  pinMode(CLOCK,OUTPUT);
}

void displayNumber(int n)
{
  digitalWrite(LATCH,LOW);
  shiftOut(DATA,CLOCK,LSBFIRST,n);
  digitalWrite(LATCH,HIGH);
}

void loop()
{
  digitalWrite(LATCH,LOW);
  shiftOut(DATA,CLOCK,LSBFIRST,ALL);
  shiftOut(DATA,CLOCK,LSBFIRST,ALL);
  digitalWrite(LATCH,HIGH);
}
