//TEMPERATURE SENSOR DISPLAY THING
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
  int t = (int)sensorToFahrenheit();
  Serial.print("Temperature: ");
  Serial.println(t);
  digitalWrite(LATCH,LOW);
  shiftOut(DATA,CLOCK,LSBFIRST,digits[t % 10]);
  shiftOut(DATA,CLOCK,LSBFIRST,digits[t / 10]);
  digitalWrite(LATCH,HIGH);
  delay(1000);
 
}

double sensorToFahrenheit()
{
  double s = analogRead(A0);
  double v = ((s*5000.0) / 1024.0) - 500.0;
  double c = (v / 10.0);
  double f = (c*1.8)+32;
  return f;
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
