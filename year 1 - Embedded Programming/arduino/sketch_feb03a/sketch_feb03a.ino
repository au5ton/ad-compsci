int receiverpin=11;			
#include <IRremote.h>          //import the library
IRrecv irrecv(receiverpin);	//receiver is in pin “receiverpin”
decode_results results;		//store decoded signal in “results”

#define R 2
#define G 3
#define B 4

void setup() {
  irrecv.enableIRIn();	//set up receiver in the correct pin
  pinMode(R,OUTPUT);
  pinMode(G,OUTPUT);
  pinMode(B,OUTPUT);
  Serial.begin(9600);
}
void loop() {
  if (irrecv.decode(&results)) { //when an IR signal is received
  Serial.println(results.value);
    if (results.value==0x810) { //if "button 2" (see chart) is pressed
      digitalWrite(2, HIGH);
      delay(1000);
      digitalWrite(2, LOW);
    }
    else if (results.value==0x810) { //if "button 2" (see chart) is pressed
      digitalWrite(2, HIGH);
      delay(1000);
      digitalWrite(2, LOW);
    }
    else if (results.value==0x810) { //if "button 2" (see chart) is pressed
      digitalWrite(2, HIGH);
      delay(1000);
      digitalWrite(2, LOW);
    }
    else if(results.value){
      Serial.println("SOEMTHINE PRESED");
    }
    //ADD ELSE-IF STATEMENTS FOR REMAINING BUTTONS
    for (int z=0; z<2; z++) {		//removes extra copies
      irrecv.resume( );
    }
  }
}


