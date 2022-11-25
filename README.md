# MVP_Pattern_example

<aside>
💡 상황 설계

</aside>

- 이름과 이메일을 입력하면 이 값들이 저장되는 기능
- 하단 text view에 저장된 값들이 출력되는 기능
- Application을 다시 시작할 때, 이미 저장된 값이 있으면 불러오는 기능

- 레이아웃 작성

완료

<aside>
💡 MVP의 구성 요소 설계하기

</aside>

- Model: 데이터의 처리
- View: 데이터의 출력
- Presenter: MV의 중재자라는 Concept

<과정을 정리>

Contractor : View와 Presenter의 Interface를 정의

Model: 이름과 이메일 데이터 처리

Presenter: Model과 View사이의 중재자

View: 이름과 이메일 Activity에 출력

즉, 사용자가 View에 이름과 이메일을 입력하고 저장하면 다음과 같은 Logic이 발생.

1. View에서 Presenter로 요청이 넘어가고
2. 이 요청은 다시 Presenter에서 Model로 넘어간다.
3. Model에서 데이터를 내부 저장소에 저장하고, Presenter에 View의 갱신을 요청한다.
4. Presenter에서는 View에 갱신될 데이터를 전달.
5. View에 갱신될 데이터를 전달받고 출력한다.

또한, Application이 새롭게 시작될 때 처리되는 Logic은 다음과 같음.

1. View에서 Presenter로 데이터의 초기화에 대한 요청을 한다.
2. Presenter에서는 이미 저장된 데이터가 있는지 Model에 요청한다.
3. Model에서는 저장된 데이터가 있는지 확인하고, 이를 Presenter로 전달한다.
4. Presenter에서는 전달받은 데이터를 View에 넘겨준다.
5. View에서는 전달받은 데이터가 있다면 View를 갱신하여, 저장된 데이터가 있음을 알림.

<aside>
💡 Contractor 작성하기

</aside>

- View에서는 다음의 기능을 가져야 한다.
    1. 데이터를 입력 받아서, 이를 Activity에 출력하는 기능을 가져야 한다.
    
- Presenter에서는 다음의 기능을 가져야 한다.
    1. Application이 시작될 때, 만약 저장된 데이터가 이를 가져온다.
    2. 데이터를 TextView에 출력할 수 있도록 View에게 데이터 출력을 요청.
    3. View의 EditText로부터 가져온 데이터를 Model에게 저장 시킴.

<aside>
💡 Model 정의하기

</aside>

<aside>
💡 Presenter 작성하기

</aside>

<aside>
💡 View 작성하기

</aside>
