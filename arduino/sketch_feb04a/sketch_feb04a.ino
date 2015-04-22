int receiverpin=11;			
#include <IRremote.h>          //import the library
IRrecv irrecv(receiverpin);	//receiver is in pin “receiverpin”
decode_results results;		//store decoded signal in “results”

#define PIN_R 3
#define PIN_G 5
#define PIN_B 6

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


boolean power = false;
int flicker = 0;
int brighten = 0;
int colorCycle = 0;
int lastColorCycle = 0;
int currentColor [] = {0,0,0}; //These are for the fading later
int nextColor [] = {0,0,0};

void update(){
  writeColor(currentColor[0],currentColor[1],currentColor[2]);
}

/*

 
 0=red
 1=orange
 2=yellow
 3=green
 4=teal
 5=lightblue
 6=blue
 7=purple
 8=magenta
 9=pink
 
 
 */

void printCurrentColor(){
  Serial.print("currentListedColor: {");
  Serial.print(currentColor[0]);
  Serial.print(", ");
  Serial.print(currentColor[1]);
  Serial.print(", ");
  Serial.print(currentColor[2]);
  Serial.println("}");
}

void switchListedColorTo(int c){
  colorCycle = c;
  switch(c){
  case 0:
    { //Red
      currentColor[0] = 255;
      currentColor[1] = 0;
      currentColor[2] = 0;
      printCurrentColor();
      break;
    }
  case 1:
    { //Orange
      currentColor[0] = 255;
      currentColor[1] = 127;
      currentColor[2] = 0;
      printCurrentColor();
      break;
    }
  case 2:
    { //Yellow
      currentColor[0] = 255;
      currentColor[1] = 255;
      currentColor[2] = 0;
      printCurrentColor();
      break;
    }
  case 3:
    { //Green
      currentColor[0] = 0;
      currentColor[1] = 255;
      currentColor[2] = 0;
      printCurrentColor();
      break;
    }
  case 4:
    { //Teal
      currentColor[0] = 0;
      currentColor[1] = 255;
      currentColor[2] = 255;
      printCurrentColor();
      break;
    }
  case 5:
    { //Lightblue
      currentColor[0] = 0;
      currentColor[1] = 127;
      currentColor[2] = 255;
      printCurrentColor();
      break;
    }
  case 6:
    { //Blue
      currentColor[0] = 0;
      currentColor[1] = 0;
      currentColor[2] = 255;
      printCurrentColor();
      break;
    }
  case 7:
    { //Purple
      currentColor[0] = 127;
      currentColor[1] = 0;
      currentColor[2] = 255;
      printCurrentColor();
      break;
    }
  case 8:
    { //Magenta
      currentColor[0] = 255;
      currentColor[1] = 0;
      currentColor[2] = 255;
      printCurrentColor();
      break;
    }
  case 9:
    { //Pink
      currentColor[0] = 255;
      currentColor[1] = 0;
      currentColor[2] = 127;
      printCurrentColor();
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

  //Brightness adjustment
  if(r+brighten > 255){
    r = 255;
  }
  else if(r+brighten < 0){
    r = 0;
  }
  else if(r+brighten == 0){
    r += brighten;
  }

  if(g+brighten > 255){
    g = 255;
  }
  else if(g+brighten < 0){
    g = 0;
  }
  else {
    g += brighten;
  }

  if(b+brighten > 255){
    b = 255;
  }
  else if(b+brighten < 0){
    b = 0;
  }
  else {
    b += brighten;
  }

  analogWrite(PIN_R,r);
  analogWrite(PIN_G,g);
  analogWrite(PIN_B,b);
}

void fadeFromColorToColor(int fromR,int fromG,int fromB,int toR,int toG,int toB){
  boolean isComplete = false;

  Serial.println("FADING");
  Serial.print("From: [");
  Serial.print(fromR);
  Serial.print(", ");
  Serial.print(fromG);
  Serial.print(", ");
  Serial.print(fromB);
  Serial.println("]");
  Serial.print("To: [");
  Serial.print(toR);
  Serial.print(", ");
  Serial.print(toG);
  Serial.print(", ");
  Serial.print(toB);
  Serial.println("]");

  while(!isComplete){

    if(fromR < toR){
      fromR++;
      writeColor(fromR,fromG,fromB);
    }
    else if(fromR > toR){
      fromR--;
      writeColor(fromR,fromG,fromB);
    }
    else if(fromR == toR){
      writeColor(fromR,fromG,fromB);
    }

    if(fromG < toG){
      fromG++;
    }
    else if(fromG > toG){
      fromG--;
    }
    else if(fromG == toG){
    }

    if(fromB < toB){
      fromB++;
    }
    else if(fromB > toB){
      fromB--;
    }
    else if(fromB == toB){
    }

    Serial.print("From: [");
    Serial.print(fromR);
    Serial.print(", ");
    Serial.print(fromG);
    Serial.print(", ");
    Serial.print(fromB);
    Serial.println("]");   

    if(fromR == toR && fromG == toG && fromB == fromB){
      isComplete = true;
    }

    delay(50);

  }

}

void setup() {
  irrecv.enableIRIn();	//set up receiver in the correct pin
  pinMode(PIN_R,OUTPUT);
  pinMode(PIN_G,OUTPUT);
  pinMode(PIN_B,OUTPUT);
  Serial.begin(9600);
  writeColor(255,255,255);
  delay(500);
  writeColor(0,0,0);
}
void loop() {
  if (irrecv.decode(&results)) { //when an IR signal is received
    Serial.println(results.value);

    if (results.value==0xA90) { //Power button
      power = !power;
      Serial.print("power: ");
      Serial.println(power);
      delay(750);
    }
    else if (results.value==0x290) { //Mute button
      if(flicker != 0){
        flicker = 0;
      }
      else {
        flicker = 1;
      }
      Serial.print("flicker: ");
      Serial.println(flicker);
      delay(750);
    }
    else if (results.value==0x490) { //Volume up
      if(brighten > 255){
        brighten = 255;
      }
      else if(brighten < 0){
        brighten = 0;
      }
      else {
        brighten += 5;
      }
      Serial.print("brightness: ");
      Serial.println(brighten);
      update();
    }
    else if (results.value==0xC90) { //Volume down 
      if(brighten > 255){
        brighten = 255;
      }
      else if(brighten < 0){
        brighten = 0;
      }
      else {
        brighten -= 5;
      }
      Serial.print("brightness: ");
      Serial.println(brighten);
      update();
    }
    else if (results.value==0x90) { //Channel up 
      if(colorCycle >= 9){
        colorCycle = 9;
      }
      else if(brighten <= 0){
        colorCycle = 0;
      }
      else {
        colorCycle++;
      }
      
      Serial.print("colorCycle: ");
      Serial.println(colorCycle);
    }

    else if (results.value==0x890) { //Channel down 
      if(colorCycle >= 9){
        colorCycle = 9;
      }
      else if(brighten <= 0){
        colorCycle = 0;
      }
      else {
        colorCycle--;
      }
      
      Serial.print("colorCycle: ");
      Serial.println(colorCycle);
    }

    else if (results.value==0x010) { //1
      //writeColor(RED);
      switchListedColorTo(0);
    }
    else if (results.value==0x810) { //2
      //writeColor(ORANGE);
      switchListedColorTo(1);
    }
    else if (results.value==0x410) { //3
      //writeColor(YELLOW);
      switchListedColorTo(2);
    }
    else if (results.value==0xC10) { //4
      //writeColor(GREEN);
      switchListedColorTo(3);
    }
    else if (results.value==0x210) { //5
      //writeColor(TEAL);
      switchListedColorTo(4);
    }
    else if (results.value==0xA10) { //6 
      //writeColor(LIGHTBLUE);
      switchListedColorTo(5);
    }
    else if (results.value==0x610) { //7
      //writeColor(BLUE);
      switchListedColorTo(6);
    }
    else if (results.value==0xE10) { //8
      //writeColor(PURPLE);
      switchListedColorTo(7);
    }
    else if (results.value==0x110) { //9
      //writeColor(MAGENTA);
      switchListedColorTo(8);
    }
    else if (results.value==0x910) { //0
      //writeColor(PINK);
      switchListedColorTo(9);
    }
    for (int z=0; z<2; z++) { //removes extra copies
      irrecv.resume( );
    }
  }
  
  if(power == true){
    if(flicker == 1){
      update();
      flicker = -1;
    }
    else if(flicker == -1){
      turnOff();
      flicker = 1;
    }
    else {
      update();
    }
  }
  else {
    turnOff();
  }

  //if colorCycle is different from currently displayed number, fade to the new color
  //if colorCycle is different from currently displayed number, fade to the new color
  //if colorCycle is different from currently displayed number, fade to the new color
  //if colorCycle is different from currently displayed number, fade to the new color
  //if colorCycle is different from currently displayed number, fade to the new color
  //if colorCycle is different from currently displayed number, fade to the new color
  //if colorCycle is different from currently displayed number, fade to the new color
  //if colorCycle is different from currently displayed number, fade to the new color
  //if colorCycle is different from currently displayed number, fade to the new color
  //if colorCycle is different from currently displayed number, fade to the new color

  delay(500);

}









