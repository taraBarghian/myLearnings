import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  var _questionIndex = 0;

  void answerQestion() {
    setState(() {
      if (_questionIndex >= 1) {
        _questionIndex = 0;
      } else {
        _questionIndex++;
      }
      print('hihihi');
    });
  }

  @override
  Widget build(BuildContext context) {
    var questions = ['what\'s your fav color?', 'what\'s your fav animal?'];

    return MaterialApp(
        home: Scaffold(
            appBar: AppBar(
              title: Text('Quiz!'),
            ),
            body: Column(
              children: [
                Text(questions.elementAt(_questionIndex)),
                RaisedButton(child: Text('Answer 1'), onPressed: answerQestion),
                RaisedButton(child: Text('Answer 2'), onPressed: answerQestion),
                RaisedButton(child: Text('Answer 3'), onPressed: answerQestion),
              ],
            )));
  }

  // ctrl + space -> auto complete

}
