import 'package:flutter/material.dart';
import 'package:introduction_screen/introduction_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp  extends StatelessWidget {




  List<PageViewModel> getPages(){


    return[

      PageViewModel(
        image: Image.asset(
          'assets/img1.png'
        ),
        title: 'YOGA SURGE',
        body: 'Welcome to the Yoga World',
        footer: Text('Inhale the future and exhale the past')
      ),


      PageViewModel(
          image: Image.asset(
              'assets/img2.png'
          ),
          title: 'HEALTHY FREAKS EXERCISE',
          body: 'Letting go is the hardest asana',
      ),


      PageViewModel(
          image: Image.asset(
              'assets/img3.png'
          ),
          title: 'CYCLING',
          body: 'You cannot always control what goes on outside. But you can always control what goes on inside.',
      ),


      PageViewModel(
          image: Image.asset(
              'assets/img4.png'
          ),
          title: 'MEDITATION',
          body: 'The longest journey of any person is the journey inward.',
      ),


      PageViewModel(
          image: Image.asset(
              'assets/img5.png'
          ),
          title: 'ANUSHKA KAIMAL',
          body: 'I like Astronomy',
          footer: Text('I think that the fact that every single atom except for helium and hydrogen atom was once a part of a stars core. We are all just stardust;)'
          )

      ),
    ];
  }



  /// The PageController that this DotsIndicator is representing.
  late final PageController controller;

  /// The number of items managed by the PageController
  late final int itemCount;

  /// Called when a dot is tapped
  late final ValueChanged<int> onPageSelected;



  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        body: IntroductionScreen(
          showNextButton: true,
          showSkipButton: false,
          showDoneButton: true,

          next:Text("NEXT"),
          //skip:Text("SKIP"),

          done: Text(
            'Done',
            style: TextStyle(
              color: Colors.white,
            ),
          ),
          onDone: (){
          },

          pages: getPages(),
          globalBackgroundColor: Colors.tealAccent,
        ),
      ),

    );
  }
}
