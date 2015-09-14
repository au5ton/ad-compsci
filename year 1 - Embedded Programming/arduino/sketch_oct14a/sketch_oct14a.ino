#define BUZZER 11

void setup()
{
  Serial.begin(9600);
  pinMode(BUZZER,OUTPUT);
}

void loop()
{
  
  int l = 4000;
  
  for(int i = 0; i < l; i++)
  {
    Serial.println(i);
    tone(BUZZER,i,30);
  }
  
  for(int i = l; i > 0; i--)
  {
    Serial.println(i);
    tone(BUZZER,i,30);
  }
}
