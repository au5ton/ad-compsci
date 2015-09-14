#define DATA 6
#define LATCH 8
#define CLOCK 10
//#define DATA 13
//#define LATCH 12
//#define CLOCK 11

byte lines1[] = {
  B00011000,
  B00001100,
  B00000110,
  B10000011,
  B11000001,
  B01100000,
  B00110000,
  B00011000
};
byte smile[] = {
  B00000000,
  B00000000,
  B01000010,
  B00000000,
  B00100100,
  B00100100,
  B00011000,
  B00000000
};

byte box[] = {
  B00000000,
  B01111110,
  B01000010,
  B01000010,
  B01000010,
  B01000010,
  B01111110,
  B00000000
};

byte circle[] = {
  B00011000,
  B00100100,
  B01000010,
  B10000001,
  B10000001,
  B01000010,
  B00100100,
  B00011000
};

byte lines2[] = {
  B01100110,
  B01100110,
  B01100110,
  B01100110,
  B01100110,
  B01100110,
  B01100110,
  B01100110
};

int binary[] = {
  1,2,4,8,16,32,64,128};

void setup()
{
  pinMode(DATA,OUTPUT);
  pinMode(LATCH,OUTPUT);
  pinMode(CLOCK,OUTPUT);
}

void loop()
{
  for(int s = 0; s < 9; s++)
  {
    for(int hold=0; hold < 10; hold++)
    {
      for (int i=0; i<8; i++)
      {
        digitalWrite(LATCH, LOW);
        shiftOut(DATA, CLOCK, MSBFIRST, box[i]>>s);
        shiftOut(DATA, CLOCK, MSBFIRST, ~binary[i]);
        digitalWrite(LATCH, HIGH);
        delay(1);
      }
    }
  }

  for(int s = 9; s > 0; s--)
  {
    for(int hold=0; hold < 10; hold++)
    {
      for (int i=0; i<8; i++)
      {
        digitalWrite(LATCH, LOW);
        shiftOut(DATA, CLOCK, MSBFIRST, box[i]<<s);
        shiftOut(DATA, CLOCK, MSBFIRST, ~binary[i]);
        digitalWrite(LATCH, HIGH);
        delay(1);
      }
    }
  }

}






