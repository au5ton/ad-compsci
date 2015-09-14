#define DATA 10
#define LATCH 6
#define CLOCK 9

void setup()
{
  Serial.begin(9600);
  randomSeed(analogRead(A0));
  pinMode(DATA,OUTPUT);
  pinMode(LATCH,OUTPUT);
  pinMode(CLOCK,OUTPUT);
}

int r;

void writeByte(byte b)
{
  digitalWrite(LATCH,LOW);
  shiftOut(DATA,CLOCK,MSBFIRST,b);
  digitalWrite(LATCH,HIGH);
}

int getSM()
{
  int answer = 0;
  Serial.print("\nWaiting");
  while(Serial.available() == 0)
  {
    Serial.print(".");
    delay(1500);
  }
  Serial.print("\n");
  while(Serial.available() > 0)
  { 
    answer *= 10;
    int z = Serial.read()- '0';
    answer += z;
  }
  return answer;
}

int generate()
{
  Serial.print("Generating");
  for(int i = 0; i < 5; i++)
  {
    Serial.print(".");
    delay(500);
  }
  Serial.print("\n");
  return random(0,255);
}

void loop()
{
  r = generate();
  writeByte((byte)r);
  Serial.print("Guess what this is: ");
  Serial.println(r,BIN);
//  Serial.print("(");
//  Serial.print(r);
//  Serial.println(")");
  int guess = getSM();
  Serial.print("You guessed: ");
  
  if(guess == r)
  {
    Serial.print("Correct! Your guess ");
    Serial.print(guess);
    Serial.print(" is ");
    Serial.print(r,BIN);
    Serial.println(" in binary.");
  }
  else
  {
    Serial.print("Wrong! Your guess ");
    Serial.print(guess,BIN);
    Serial.print(" is NOT ");
    Serial.print(r);
    Serial.println(" in binary.");
    Serial.println("Better luck next time!");
  }
  
  delay(1000);
}

