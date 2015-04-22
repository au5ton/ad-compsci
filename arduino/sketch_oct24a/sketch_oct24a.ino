#define DATA 10
#define LATCH 6
#define CLOCK 9

const int segmentSize = 10;
int segmentInts[] = {3,159,37,13,153,73,65,31,1,25};
byte segmentBytes[] = {B00000011,B10011111,B00100101,B00001101,B10011001,B01001001,B01000001,B00011111,B00000001,B00011001};

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
  if(n >= 0 && n <= 9)
  {
    digitalWrite(LATCH,LOW);
    shiftOut(DATA,CLOCK,LSBFIRST,segmentInts[n]);
    digitalWrite(LATCH,HIGH);
  }
  else
  {
    digitalWrite(LATCH,LOW);
    shiftOut(DATA,CLOCK,LSBFIRST,B01100001); // E for error
    digitalWrite(LATCH,HIGH);
  }
  
}

void loop()
{
  int i = random(0,10);
    displayNumber(i);
    Serial.println(i);
    delay(1500);
}


