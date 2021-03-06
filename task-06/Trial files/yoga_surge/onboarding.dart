import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:yoga_surge/Home.dart';
import 'package:yoga_surge/content_model.dart';
//import 'C:\/Dev/flutter/packages/flutter/lib/material.dart';


class Onboarding extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _OnboardingState();

}

class _OnboardingState extends State<Onboarding> {
  int currentIndex = 0;
  late PageController _controller;

  @override
  void initState() {
    _controller = PageController(initialPage: 0);
      super.initState();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      body: Column(
        children: [
          Expanded(
            child: PageView.builder(
              controller: _controller,
              itemCount: contents.length,
              onPageChanged: (int index){
                setState(() {
                  currentIndex = index;
                });
    },
              itemBuilder: (_,i){
                return Padding(
                  padding: const EdgeInsets.all(40),
                    child:  Column(
                        children: [
                          SvgPicture.asset(
                            contents[i].image,
                            height: 300,
                          ),
                          Text(
                              contents[i].title,
                              style:TextStyle(
                                fontSize: 35,
                                fontWeight: FontWeight.bold,
                          ),
                          ),
                          SizedBox(height:20),
                          Text(
                            contents[i].description,
                            textAlign: TextAlign.center,
                            style: TextStyle(
                              fontSize: 20,
                              color: Colors.grey,
                            ),
                          )
                        ],
                    ),
                );

                },
            ),
          ),
          Container(
            child: Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: List.generate(
                contents.length,
                  (index) => buildDot(index,context),
              ),
            ),
          ),
          Container(
            height: 60,
            margin: EdgeInsets.all(40),
            width: double.infinity,
            color: Theme.of(context).primaryColor,
            child: FlatButton(
              child: Text(currentIndex == contents.length-1? "Get Started": "Next"),
              onPressed: (){

                if(currentIndex== contents.length-1){
                  Navigator.push(context, MaterialPageRoute(builder: (_)=> Home(),
                  ),
                  );

                }
                _controller.nextPage(
                  duration: Duration(milliseconds: 100),
                  curve: Curves.bounceIn,
                );
              },
              color: Theme.of(context).primaryColor,
              textColor: Colors.black,
              shape: RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(20)
              ),

            ),
          )
        ],
      ),

    );
  }

  Container buildDot(int index,BuildContext context) {
    return Container(
                  height: 10,
                  width: currentIndex == index ? 20:10 ,
                  margin: EdgeInsets.only(right: 5),
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(20),
                    color: Theme.of(context).primaryColor,
                  ),
                );
  }
}
