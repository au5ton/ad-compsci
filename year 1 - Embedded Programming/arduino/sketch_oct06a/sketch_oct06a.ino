#define BLUE 2
#define GREEN 3
#define RED 4
#define THERM A0
#define BUZZER 11

void setup()
{
  Serial.begin(9600);
  pinMode(BLUE,OUTPUT);
  pinMode(GREEN,OUTPUT);
  pinMode(RED,OUTPUT);
  //pinMode(BUZZER,OUTPUT);
  //pinMode(THERM,INPUT);
}

void loop()
{
  Serial.print("Temp (F): ");
  double temp = voltsToFarhenheit(analogRead(0));
  Serial.println(temp);
  
  if(temp > 80.0)
  {
    digitalWrite(RED,HIGH);
    delay(100);
  }
  else if(temp > 60.0 && temp < 80.0)
  {
    digitalWrite(GREEN,HIGH);
    delay(100);
  }
  else if(temp < 60.0)
  {
    digitalWrite(BLUE,HIGH);
    delay(100);
  }
  digitalWrite(RED,LOW);
  digitalWrite(GREEN,LOW);
  digitalWrite(BLUE,LOW);
  
}

double voltsToCelsius(int sensor)
{
  double volts = (sensor*5000.0)/1024.0;
  volts = volts - 500.0;
  return (volts / 10.0);
}

double celsiusToFarhenheit(double c)
{
  return ( (c*1.8)+32 );
}

double farhenheitToCelsius(double f)
{
  return ( (f/1.8)-32 );
}

double voltsToFarhenheit(int v)
{
  return celsiusToFarhenheit(voltsToCelsius(v));
}
