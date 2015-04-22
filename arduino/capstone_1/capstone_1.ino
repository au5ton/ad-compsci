
#include <Tone.h>

/*
  Melody
 
 Plays a melody 
 
 circuit:
 * 8-ohm speaker on digital pin 8
 
 created 21 Jan 2010
 modified 30 Aug 2011
 by Tom Igoe 
 
 This example code is in the public domain.
 
 http://arduino.cc/en/Tutorial/Tone
 
 */
//colors
#define RED 255,0,0
#define ORANGE 255,127,0
#define YELLOW 255,255,0
#define GREEN 0,255,0
#define TEAL 0,255,255
#define LIGHTBLUE 0,127,255
#define BLUE 0,0,255
#define PURPLE 127,0,255
#define MAGENTA 255,0,255
#define PINK 255,0,127

#define SONG 1
#define INSTRUMENT 2

//pins
#define PIN_R 5
#define PIN_G 6
#define PIN_B 9
#define PIN_BUZZER 3
#define PIN_RECEIVER 11
#define PIN_DIAL A5

int receiverpin=11;
#include <IRremote.h>          //import the library
IRrecv irrecv(receiverpin);	//receiver is in pin “receiverpin”
decode_results results;		//store decoded signal in “results”

// notes in the melody:
int song_melody[] = {
  NOTE_C4, NOTE_G3,NOTE_G3, NOTE_A3, NOTE_G3,0, NOTE_B3, NOTE_C4};

// note durations: 4 = quarter note, 8 = eighth note, etc.:
int song_tempo[] = {
  4, 8, 8, 4, 4, 4, 4, 4};

void playSong(int s) {

  // iterate over the notes of the melody:
  for (int thisNote = 0; thisNote < 8; thisNote++) {

    // to calculate the note duration, take one second 
    // divided by the note type.
    //e.g. quarter note = 1000 / 4, eighth note = 1000/8, etc.
    int noteDuration = 1000/song_tempo[thisNote];
    //tone(8, song_melody[thisNote],noteDuration);

    // to distinguish the notes, set a minimum time between them.
    // the note's duration + 30% seems to work well:
    int pauseBetweenNotes = noteDuration * 1.30;
    delay(pauseBetweenNotes);
    // stop the tone playing:
    //noTone(8);
  }

}
Tone buzzer; //The pietzo object used for producing sound
int currentColor [] = {
  0,0,0}; //Current color written to the RGB LED
int keepOn = 0; //LED diminishes over time after being activated (see line ###)
int octave = 3; //Octave of note controlled by channel buttons
boolean sharp = false;
int sharpDiminish = 0; //Sharp diminishes over time the same way the LED does
int dlt = 250; //Note duration controlled by volume buttons
boolean n = false; //note is pressed
int mode = INSTRUMENT; // 'Input' thing
int knob = 1000; //the stored value from the dial/knob/potentiometer

//Method for playing notes easily while also applying the current octave and if the note is sharp or not
// LOTS of if statements and even a switch because why not
void playNote(char n){

  switch(n){

  case 'c':
    {
      if (octave == 2){
        if(sharp){
          buzzer.play(NOTE_CS2);
          Serial.println("sharp");
        }
        else {
          buzzer.play(NOTE_C2);
          Serial.println("normal");
        }
      }
      else if (octave == 3){
        if(sharp){
          buzzer.play(NOTE_CS3);
        }
        else {
          buzzer.play(NOTE_C3);
        }
      }
      else if (octave == 4){
        if(sharp){
          buzzer.play(NOTE_CS4);
        }
        else {
          buzzer.play(NOTE_C4);
        }
      }
      else if (octave == 5){
        if(sharp){
          buzzer.play(NOTE_CS5);
        }
        else {
          buzzer.play(NOTE_C5);
        }
      }
      else if (octave == 6){
        if(sharp){
          buzzer.play(NOTE_CS6);
        }
        else {
          buzzer.play(NOTE_C6);
        }
      }
      break;
    }
  case 'b':
    {
      if (octave == 2){
        buzzer.play(NOTE_B2);
      }
      else if (octave == 3){
        buzzer.play(NOTE_B3);
      }
      else if (octave == 4){
        buzzer.play(NOTE_B4);
      }
      else if (octave == 5){
        buzzer.play(NOTE_B5);
      }
      else if (octave == 6){
        buzzer.play(NOTE_B6);
      }
      break;
    }
  case 'a':
    {
      if (octave == 2){
        if(sharp){
          buzzer.play(NOTE_AS2);
        }
        else {
          buzzer.play(NOTE_A2);
        }
      }
      else if (octave == 3){
        if(sharp){
          buzzer.play(NOTE_AS3);
        }
        else {
          buzzer.play(NOTE_A3);
        }
      }
      else if (octave == 4){
        if(sharp){
          buzzer.play(NOTE_AS4);
        }
        else {
          buzzer.play(NOTE_A4);
        }
      }
      else if (octave == 5){
        if(sharp){
          buzzer.play(NOTE_AS5);
        }
        else {
          buzzer.play(NOTE_A5);
        }
      }
      else if (octave == 6){
        if(sharp){
          buzzer.play(NOTE_AS6);
        }
        else {
          buzzer.play(NOTE_A6);
        }
      }
      break;
    }
  case 'g':
    {
      if (octave == 2){
        if(sharp){
          buzzer.play(NOTE_GS2);
        }
        else {
          buzzer.play(NOTE_G2);
        }
      }
      else if (octave == 3){
        if(sharp){
          buzzer.play(NOTE_GS3);
        }
        else {
          buzzer.play(NOTE_G3);
        }
      }
      else if (octave == 4){
        if(sharp){
          buzzer.play(NOTE_GS4);
        }
        else {
          buzzer.play(NOTE_G4);
        }
      }
      else if (octave == 5){
        if(sharp){
          buzzer.play(NOTE_GS5);
        }
        else {
          buzzer.play(NOTE_G5);
        }
      }
      else if (octave == 6){
        if(sharp){
          buzzer.play(NOTE_GS6);
        }
        else {
          buzzer.play(NOTE_G6);
        }
      }
      break;
    }
  case 'f':
    {
      if (octave == 2){
        if(sharp){
          buzzer.play(NOTE_FS2);
        }
        else {
          buzzer.play(NOTE_F2);
        }
      }
      else if (octave == 3){
        if(sharp){
          buzzer.play(NOTE_FS3);
        }
        else {
          buzzer.play(NOTE_F3);
        }
      }
      else if (octave == 4){
        if(sharp){
          buzzer.play(NOTE_FS4);
        }
        else {
          buzzer.play(NOTE_F4);
        }
      }
      else if (octave == 5){
        if(sharp){
          buzzer.play(NOTE_FS5);
        }
        else {
          buzzer.play(NOTE_F5);
        }
      }
      else if (octave == 6){
        if(sharp){
          buzzer.play(NOTE_FS6);
        }
        else {
          buzzer.play(NOTE_F6);
        }
      }
      break;
    }
  case 'e':
    {
      if (octave == 2){
        buzzer.play(NOTE_E2);
      }
      else if (octave == 3){
        buzzer.play(NOTE_E3);
      }
      else if (octave == 4){
        buzzer.play(NOTE_E4);
      }
      else if (octave == 5){
        buzzer.play(NOTE_E5);
      }
      else if (octave == 6){
        buzzer.play(NOTE_E6);
      }
      break;
    }
  case 'd':
    {
      if (octave == 2){
        if(sharp){
          buzzer.play(NOTE_DS2);
        }
        else {
          buzzer.play(NOTE_D2);
        }
      }
      else if (octave == 3){
        if(sharp){
          buzzer.play(NOTE_DS3);
        }
        else {
          buzzer.play(NOTE_D3);
        }
      }
      else if (octave == 4){
        if(sharp){
          buzzer.play(NOTE_DS4);
        }
        else {
          buzzer.play(NOTE_D4);
        }
      }
      else if (octave == 5){
        if(sharp){
          buzzer.play(NOTE_DS5);
        }
        else {
          buzzer.play(NOTE_D5);
        }
      }
      else if (octave == 6){
        if(sharp){
          buzzer.play(NOTE_DS6);
        }
        else {
          buzzer.play(NOTE_D6);
        }
      }
      break;
    }
  case 'C':
    {
      if (octave == 2){
        if(sharp){
          buzzer.play(NOTE_CS3);
        }
        else {
          buzzer.play(NOTE_C3);
        }
      }
      else if (octave == 3){
        if(sharp){
          buzzer.play(NOTE_CS4);
        }
        else {
          buzzer.play(NOTE_C4);
        }
      }
      else if (octave == 4){
        if(sharp){
          buzzer.play(NOTE_CS5);
        }
        else {
          buzzer.play(NOTE_C5);
        }
      }
      else if (octave == 5){
        if(sharp){
          buzzer.play(NOTE_CS6);
        }
        else {
          buzzer.play(NOTE_C6);
        }
      }
      else if (octave == 6){
        if(sharp){
          buzzer.play(NOTE_CS7);
        }
        else {
          buzzer.play(NOTE_C7);
        }
      }
      break;
    }



  }

}

void turnOff(){
  analogWrite(PIN_R,0);
  analogWrite(PIN_G,0);
  analogWrite(PIN_B,0);
}

void writeColor(int r, int g, int b){
  analogWrite(PIN_R,r);
  analogWrite(PIN_G,g);
  analogWrite(PIN_B,b);
  currentColor[0] = r;
  currentColor[1] = g;
  currentColor[2] = b;
}

void update(){
  writeColor(currentColor[0],currentColor[1],currentColor[2]);
}

void setup() {
  pinMode(PIN_R,OUTPUT);
  pinMode(PIN_G,OUTPUT);
  pinMode(PIN_B,OUTPUT);
  pinMode(PIN_BUZZER,OUTPUT);
  pinMode(PIN_RECEIVER,INPUT);
  pinMode(PIN_DIAL,INPUT);
  irrecv.enableIRIn();	//set up receiver in the correct pin
  Serial.begin(9600);
  buzzer.begin(3);
  buzzer.play(NOTE_C3);
  writeColor(255,255,255);
  delay(250);
  writeColor(0,0,0);
}




void loop() {

  knob = analogRead(PIN_DIAL);

  irrecv.decode(&results);
  if (irrecv.decode(&results)) {//when an IR signal is received
    //Serial.println(results.value,16);


    if(mode == INSTRUMENT){
      if(results.value==0xA90) { //power button

      }
      if (results.value==0x290) { //Mute button
        sharp = !sharp;
        delay(100);
      }
      else if (results.value==0x490) { //Volume up
        dlt+=5;
        Serial.print("note duration: ");
        Serial.println(dlt);
      }
      else if (results.value==0xC90) { //Volume down 
        if(dlt - 5 > 0){
          dlt-=5;
        }
        Serial.print("note duration: ");
        Serial.println(dlt);
      }
      else if (results.value==0xA50) { //input
        mode = SONG;
        delay(250);
        Serial.println("NOW IN SONG MODE!");
      }
      else if (results.value==0x90) { //Channel up 
        if(octave < 6){
          octave++;
        }
        Serial.print("octave: ");
        Serial.println(octave);
        delay(250);
      }
      else if (results.value==0x890) { //Channel down 
        if(octave > 2){
          octave--;
        }
        Serial.print("octave: ");
        Serial.println(octave);
        delay(250);
      }
      if (results.value==0x010) { //1
        playNote('C');
        writeColor(RED);
        keepOn = 0;
        n = true;
        Serial.println("note: C");
      }
      else if (results.value==0x810) { //2
        playNote('b');
        writeColor(ORANGE);
        keepOn = 0;
        n = true;
        Serial.println("note: b");
      }
      else if (results.value==0x410) { //3
        playNote('a');
        writeColor(YELLOW);
        keepOn = 0;
        n = true;
        Serial.println("note: a");
      }
      else if (results.value==0xC10) { //4
        playNote('g');
        writeColor(GREEN);
        keepOn = 0;
        n = true;
        Serial.println("note: g");
      }
      else if (results.value==0x210) { //5
        playNote('f');
        writeColor(TEAL);
        keepOn = 0;
        n = true;
        Serial.println("note: f");
      }
      else if (results.value==0xA10) { //6 
        playNote('e');
        writeColor(BLUE);
        keepOn = 0;
        n = true;
        Serial.println("note: e");
      }
      else if (results.value==0x610) { //7
        playNote('d');
        writeColor(PURPLE);
        keepOn = 0;
        n = true;
        Serial.println("note: d");
      }
      else if (results.value==0xE10) { //8
        playNote('c');
        writeColor(MAGENTA);
        keepOn = 0;
        n = true;
        Serial.println("note: c");
      }
      else if (results.value==0x110) { //9
        //
      }
      else if (results.value==0x910) { //0
        //
      }
      else {

      }
      if(n){
        delay(dlt);
      }

      n = false;
    }
    else if(mode == SONG) {

      if(results.value==0xA90) { //power button

      }
      if (results.value==0x290) { //Mute button

      }
      else if (results.value==0x490) { //Volume up

      }
      else if (results.value==0xC90) { //Volume down 

      }
      else if (results.value==0xA50) { //input
        mode = INSTRUMENT;
        delay(250);
        Serial.println("NOW IN INSTRUMENT MODE!");
      }
      else if (results.value==0x90) { //Channel up 

      }
      else if (results.value==0x890) { //Channel down 

      }
      if (results.value==0x010) { //1
        sing(1);
      }
      else if (results.value==0x810) { //2
        sing(2);
      }
      else if (results.value==0x410) { //3
        Poke_theme();
      }
      else if (results.value==0xC10) { //4

      }
      else if (results.value==0x210) { //5

      }
      else if (results.value==0xA10) { //6 

      }
      else if (results.value==0x610) { //7

      }
      else if (results.value==0xE10) { //8

      }
      else if (results.value==0x110) { //9
        //
      }
      else if (results.value==0x910) { //0
        //
      }
      else {

      }

    }


    for (int z=0; z<2; z++) { //removes extra copies
      irrecv.resume();
    }
  }
  else {
    //noTone(PIN_BUZZER);
    if(keepOn > 60){
      //Serial.println("LED not in use");
      writeColor(0,0,0);
      buzzer.stop();
    }
    else {
      keepOn++;
    }

    //Serial.println("Buzzer stopped");
    buzzer.stop();
  }



}
int melody[] = {
  NOTE_E7, NOTE_E7, 0, NOTE_E7,
  0, NOTE_C7, NOTE_E7, 0,
  NOTE_G7, 0, 0,  0,
  NOTE_G6, 0, 0, 0,

  NOTE_C7, 0, 0, NOTE_G6,
  0, 0, NOTE_E6, 0,
  0, NOTE_A6, 0, NOTE_B6,
  0, NOTE_AS6, NOTE_A6, 0,

  NOTE_G6, NOTE_E7, NOTE_G7,
  NOTE_A7, 0, NOTE_F7, NOTE_G7,
  0, NOTE_E7, 0, NOTE_C7,
  NOTE_D7, NOTE_B6, 0, 0,

  NOTE_C7, 0, 0, NOTE_G6,
  0, 0, NOTE_E6, 0,
  0, NOTE_A6, 0, NOTE_B6,
  0, NOTE_AS6, NOTE_A6, 0,

  NOTE_G6, NOTE_E7, NOTE_G7,
  NOTE_A7, 0, NOTE_F7, NOTE_G7,
  0, NOTE_E7, 0, NOTE_C7,
  NOTE_D7, NOTE_B6, 0, 0
};
//Mario main them tempo
int tempo[] = {
  12, 12, 12, 12,
  12, 12, 12, 12,
  12, 12, 12, 12,
  12, 12, 12, 12,

  12, 12, 12, 12,
  12, 12, 12, 12,
  12, 12, 12, 12,
  12, 12, 12, 12,

  9, 9, 9,
  12, 12, 12, 12,
  12, 12, 12, 12,
  12, 12, 12, 12,

  12, 12, 12, 12,
  12, 12, 12, 12,
  12, 12, 12, 12,
  12, 12, 12, 12,

  9, 9, 9,
  12, 12, 12, 12,
  12, 12, 12, 12,
  12, 12, 12, 12,
};
//Underworld melody
int underworld_melody[] = {
  NOTE_C4, NOTE_C5, NOTE_A3, NOTE_A4,
  NOTE_AS3, NOTE_AS4, 0,
  0,
  NOTE_C4, NOTE_C5, NOTE_A3, NOTE_A4,
  NOTE_AS3, NOTE_AS4, 0,
  0,
  NOTE_F3, NOTE_F4, NOTE_D3, NOTE_D4,
  NOTE_DS3, NOTE_DS4, 0,
  0,
  NOTE_F3, NOTE_F4, NOTE_D3, NOTE_D4,
  NOTE_DS3, NOTE_DS4, 0,
  0, NOTE_DS4, NOTE_CS4, NOTE_D4,
  NOTE_CS4, NOTE_DS4,
  NOTE_DS4, NOTE_GS3,
  NOTE_G3, NOTE_CS4,
  NOTE_C4, NOTE_FS4, NOTE_F4, NOTE_E3, NOTE_AS4, NOTE_A4,
  NOTE_GS4, NOTE_DS4, NOTE_B3,
  NOTE_AS3, NOTE_A3, NOTE_GS3,
  0, 0, 0
};
//Underwolrd tempo
int underworld_tempo[] = {
  12, 12, 12, 12,
  12, 12, 6,
  3,
  12, 12, 12, 12,
  12, 12, 6,
  3,
  12, 12, 12, 12,
  12, 12, 6,
  3,
  12, 12, 12, 12,
  12, 12, 6,
  6, 18, 18, 18,
  6, 6,
  6, 6,
  6, 6,
  18, 18, 18, 18, 18, 18,
  10, 10, 10,
  10, 10, 10,
  3, 3, 3
};

int song = 0;
void sing(int s) {
  // iterate over the notes of the melody:
  song = s;
  if (song == 2) {
    Serial.println(" 'Underworld Theme'");
      Serial.println(sizeof(underworld_melody) / sizeof(int));
  Serial.print("Tempo size: ");
  Serial.println(sizeof(underworld_tempo) / sizeof(int));
    int size = sizeof(underworld_melody) / sizeof(int);
    for (int thisNote = 0; thisNote < size; thisNote++) {
      knob = analogRead(PIN_DIAL);
      // to calculate the note duration, take one second
      // divided by the note type.
      //e.g. quarter note = 1000 / 4, eighth note = 1000/8, etc.
      int noteDuration = ((knob+1)*2) / underworld_tempo[thisNote];

      buzz(PIN_BUZZER, underworld_melody[thisNote], noteDuration);

      // to distinguish the notes, set a minimum time between them.
      // the note's duration + 30% seems to work well:
      int pauseBetweenNotes = noteDuration * 1.30;
      delay(pauseBetweenNotes);

      // stop the tone playing:
      buzz(PIN_BUZZER, 0, noteDuration);

    }
    Serial.println("(Song ended)");

  } 
  else {

    Serial.println(" 'Mario Theme'");
    int size = sizeof(melody) / sizeof(int);
    for (int thisNote = 0; thisNote < size; thisNote++) {
      knob = analogRead(PIN_DIAL);
      // to calculate the note duration, take one second
      // divided by the note type.
      //e.g. quarter note = 1000 / 4, eighth note = 1000/8, etc.
      int noteDuration = ((knob+1)*2) / tempo[thisNote];

      buzz(PIN_BUZZER, melody[thisNote], noteDuration);

      // to distinguish the notes, set a minimum time between them.
      // the note's duration + 30% seems to work well:
      int pauseBetweenNotes = noteDuration * 1.30;
      delay(pauseBetweenNotes);

      // stop the tone playing:
      buzz(PIN_BUZZER, 0, noteDuration);

    }
    Serial.println("(Song ended)");
  }
}

void buzz(int targetPin, long frequency, long length) {
  digitalWrite(13, HIGH);
  long delayValue = 1000000 / frequency / 2; // calculate the delay value between transitions
  //// 1 second's worth of microseconds, divided by the frequency, then split in half since
  //// there are two phases to each cycle
  long numCycles = frequency * length / 1000; // calculate the number of cycles for proper timing
  //// multiply frequency, which is really cycles per second, by the number of seconds to
  //// get the total number of cycles to produce
  for (long i = 0; i < numCycles; i++) { // for the calculated length of time...
    digitalWrite(targetPin, HIGH); // write the buzzer pin high to push out the diaphram
    delayMicroseconds(delayValue); // wait for the calculated delay value
    digitalWrite(targetPin, LOW); // write the buzzer pin low to pull back the diaphram
    delayMicroseconds(delayValue); // wait again or the calculated delay value
  }
  digitalWrite(13, LOW);

}

//Underworld melody
int pokemon_melody [] = {
  NOTE_D4, NOTE_F4,

  NOTE_G4, NOTE_G4, 0, NOTE_G4, NOTE_G4, NOTE_G4,

  NOTE_G4, NOTE_G4, NOTE_F4, NOTE_F4, NOTE_F4, NOTE_F4, NOTE_F4, NOTE_FS4,
  
  NOTE_G5, NOTE_B5, NOTE_D5,

  0,0, NOTE_F5, NOTE_E5, NOTE_DS5,

  NOTE_D5, NOTE_E5, NOTE_E5, NOTE_DS5,

  NOTE_D4,NOTE_C4, NOTE_B4, NOTE_C4,

  NOTE_G4, NOTE_B5, NOTE_D5,
  
  0,0, NOTE_C5, NOTE_B5, NOTE_C5, 

  NOTE_D5, NOTE_F4, NOTE_E3, NOTE_C3, 

  NOTE_D3, NOTE_B3, NOTE_C3, NOTE_D3,

  NOTE_G3,  NOTE_B5, NOTE_D5, 

  0,0, NOTE_F6, NOTE_E5, NOTE_DS5, 

  NOTE_D5, NOTE_F3, NOTE_E3, NOTE_DS3,

  NOTE_D3, NOTE_C3, NOTE_B3, NOTE_C3,

  NOTE_G4, NOTE_B5, NOTE_D5,

  NOTE_G4, NOTE_F4, NOTE_A4, NOTE_F6, NOTE_E5, NOTE_F6,

  NOTE_G6, NOTE_AS6, NOTE_G6,

  NOTE_G4, NOTE_A6, NOTE_A5, NOTE_C5,
  
  NOTE_AS6, NOTE_F6, NOTE_F6, NOTE_E6,
  
  NOTE_D5, NOTE_AS6, NOTE_B6,
  
  NOTE_C6, NOTE_G5,NOTE_G5, NOTE_F5
};

/*NOTE_AS3, NOTE_AS4, 0,
 0,
 NOTE_C4, NOTE_C5, NOTE_A3, NOTE_A4,
 NOTE_AS3, NOTE_AS4, 0,
 0,
 NOTE_F3, NOTE_F4, NOTE_D3, NOTE_D4,
 NOTE_DS3, NOTE_DS4, 0,
 0,
 NOTE_F3, NOTE_F4, NOTE_D3, NOTE_D4,
 NOTE_DS3, NOTE_DS4, 0,
 0, NOTE_DS4, NOTE_CS4, NOTE_D4,
 NOTE_CS4, NOTE_DS4,
 NOTE_DS4, NOTE_GS3,
 NOTE_G3, NOTE_CS4,
 NOTE_C4, NOTE_FS4, NOTE_F4, NOTE_E3, NOTE_AS4, NOTE_A4,
 NOTE_GS4, NOTE_DS4, NOTE_B3,
 NOTE_AS3, NOTE_A3, NOTE_GS3,
 0, 0, 0
 };
 */
//Underwolrd tempo
int pokemon_tempo[] = {
  16, 16,
 4, 4, 8, 16,16, 4,
 4, 4, 12, 12, 12,12,12,12, 
  3,8, 2,
  2, 3, 16, 16,
  2, 3, 16, 16,
  2,8,8,8,
  3,8,2,
  2,8,8,8,
  2,8,8,8,
  3,8,8,8,
  3,8,2,
  2,3,16,16,
  2,3,16,16,
  2,8,8,8,
  3, 8, 2,
  8,8,8,8,8,8,
  3,8,2, 
  2,4,8,8,
  3,8,2,4,
  2,4,4,
  3,8,2,4,
  0,0,0
  
  
  
 
 
};

void Poke_theme() {

  Serial.println(" 'Pokemon Theme'");
  Serial.print("Melody size: ");
  Serial.println(sizeof(pokemon_melody) / sizeof(int));
  Serial.print("Tempo size: ");
  Serial.println(sizeof(pokemon_tempo) / sizeof(int));
  int size = sizeof(pokemon_melody) / sizeof(int);
  for (int thisNote = 0; thisNote < size; thisNote++) {
    knob = analogRead(PIN_DIAL);
    // to calculate the note duration, take one second
    // divided by the note type.
    //e.g. quarter note = 1000 / 4, eighth note = 1000/8, etc.
    int noteDuration = ((knob+1)*2) / pokemon_tempo[thisNote];

    buzz(PIN_BUZZER, pokemon_melody[thisNote], noteDuration);

    // to distinguish the notes, set a minimum time between them.
    // the note's duration + 30% seems to work well:
    int pauseBetweenNotes = noteDuration * 1.30;
    delay(pauseBetweenNotes);

    // stop the tone playing:
    buzz(PIN_BUZZER, 0, noteDuration);
    
    if(thisNote > 80) {
      break;
    }

  }

}


