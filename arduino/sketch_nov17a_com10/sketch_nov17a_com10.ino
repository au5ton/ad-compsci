#define LATCH 10
#define CLOCK 6
#define DATA 8
#define SECONDS 1000
#define ALL B11111111
#define NONE B00000000

const int digits[] = {3,159,37,13,153,73,65,31,1,25};

void setup()
{
  pinMode(2,OUTPUT);
  digitalWrite(2,LOW);
  delay(10*SECONDS);
}

void loop()
{
  digitalWrite(2,HIGH);
  
  digitalWrite(LATCH,LOW);
  shiftOut(DATA,CLOCK,LSBFIRST,ALL);
  shiftOut(DATA,CLOCK,LSBFIRST,NONE);
  digitalWrite(LATCH,HIGH);
  
  delay(2*SECONDS);
  
  
  digitalWrite(LATCH,LOW);
  shiftOut(DATA,CLOCK,LSBFIRST,NONE);
  shiftOut(DATA,CLOCK,LSBFIRST,ALL);
  digitalWrite(LATCH,HIGH);
  
  delay(2*SECONDS);
}
