import 'package:flutter/material.dart';

// void main(List<String> args) {
//   runApp(MyApp());
// }

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
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
                Text('The questions!'),
                RaisedButton(
                    child: Text('Answer 1'),
                    onPressed: () {
                      print('Answer 1 chosen');
                    }),
                RaisedButton(
                  child: Text('Answer 2'),
                  onPressed: () => print('Answer 2 chosen'),
                ),
                RaisedButton(
                  child: Text('Answer 3'),
                  onPressed: answerQestion,
                ),
              ],
            )));
  }

  void answerQestion() {
    print('Answer 3 chosen');
  }
  // ctrl + space -> auto complete

}
