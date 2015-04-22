void setup()
{
  Serial.begin(9600);
  randomSeed(analogRead(A0));
}

const int s = 10;
int arr[10];

void loop()
{
  Serial.print("[");
  for(int i = 0; i < s; i++)
  {
    arr[i] = random(0,100);
    Serial.print(arr[i]);
    Serial.print(",");
  }
  Serial.println("]");
  delay(5000);
}
