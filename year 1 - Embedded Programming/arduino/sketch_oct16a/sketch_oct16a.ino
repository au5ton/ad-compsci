#define RED 4
#define GREEN 3
#define BLUE 2
#define BUZZER 11

int incoming = 0;

void setup()
{
  Serial.begin(9600);
  pinMode(RED,OUTPUT);
  pinMode(GREEN,OUTPUT);
  pinMode(BLUE,OUTPUT);
  pinMode(BUZZER,OUTPUT);
}

boolean red = false;
boolean green = false;
boolean blue = false;

void refresh()
{
  if(red)
  {
    digitalWrite(RED,HIGH);
  }
  else
  {
    digitalWrite(RED,LOW);
  }
  if(green)
  {
    digitalWrite(GREEN,HIGH);
  }
  else
  {
    digitalWrite(GREEN,LOW);
  }
  if(blue)
  {
    digitalWrite(BLUE,HIGH);
  }
  else
  {
    digitalWrite(BLUE,LOW);
  }
}

void toggle(int l)
{
  if(l == RED)
  {
    if(red == true)
    {
      red = false;
    }
    else
    {
      red = true;
    }
  }
  else if(l == GREEN)
  {
    if(green == true)
    {
      green = false;
    }
    else
    {
      green = true;
    }
  }
  else if(l == BLUE)
  {
    if(blue == true)
    {
      blue = false;
    }
    else
    {
      blue = true;
    }
  }
}

void loop()
{
  if(Serial.available() > 0)
  {
    incoming = Serial.read() - '0';
    Serial.println(incoming, DEC);
    
    if(incoming == RED)
    {
      toggle(RED);
    }
    else if(incoming == GREEN)
    {
      toggle(GREEN);
    }
    else if(incoming == BLUE)
    {
      toggle(BLUE);
    }
    refresh();
  }
}
