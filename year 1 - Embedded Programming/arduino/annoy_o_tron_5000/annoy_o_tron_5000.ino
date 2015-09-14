#define BUZZER 11

void setup()
{
  Serial.begin(9600);
  pinMode(BUZZER,OUTPUT);
}

void loop()
{
  
  int l = 4000;
  int d = 1000;
  
//  for(int i = 0; i < l; i++)
//  {
//    Serial.println(i);
//    tone(BUZZER,i,d);
//  }
//  
//  for(int i = l; i > 0; i--)
//  {
//    Serial.println(i);
//    tone(BUZZER,i,d);
//  }
  int i = random(0,4000);
  Serial.println(i);
  tone(BUZZER,i,d);
  
}
