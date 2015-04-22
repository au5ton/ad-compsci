#define DATA 6
#define LATCH 8
#define CLOCK 10
#define ALL B11111111
#define NONE B00000000

int digits[] = {3,159,37,13,153,73,65,31,1,25};

void setup()
{
  Serial.begin(9600);
  randomSeed(analogRead(A5));
  pinMode(DATA,OUTPUT);
  pinMode(LATCH,OUTPUT);
  pinMode(CLOCK,OUTPUT);
}

void loop()
{
  Serial.print("Enter number...");
  int n = getNumber();
  Serial.println("Received!");
  Serial.print("First digit:");
  Serial.println(n / 10);
  Serial.print("Second digit:");
  Serial.println(n % 10);
  digitalWrite(LATCH,LOW);
  shiftOut(DATA,CLOCK,LSBFIRST,digits[n % 10]);
  shiftOut(DATA,CLOCK,LSBFIRST,digits[n / 10]);
  digitalWrite(LATCH,HIGH);
}

int getNumber()
{
  int f = 0;
  while(Serial.available() == 0)
  {
    //
  }
  
  while(Serial.available() > 0)
  {
    f *= 10;
    int i = Serial.read() - '0';
    f += i;
    delay(5);
  }
  
  return f;
}
