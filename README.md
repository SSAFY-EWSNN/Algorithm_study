# 🏝️ 싸피에서 살아남기(알고리즘 편)

<b>Member : 👨‍💻성우, 👨‍💻민우, 👩‍💻슬기, 👩‍💻정언, 👩‍💻희진</b><br/><br/>
Git 관리는 <a href="https://github.com/mccreate"><b>👨‍💻민우</b></a>가 할게요.<br/>
[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FSSAFY-EWSNN&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)
<br/><br/>

# 📆 일정표 공유
<details> 
<summary>
1주차 - 완전탐색 ✓
</summary>

- Programmers 고득점 Kit - 최소 직사각형 (86491) <br>

- SWEA - 조교의 성적 매기기 (1983)

</details>

<details>
<summary>
2주차 - 완전탐색, 백트래킹 ✓
</summary>
<br>

- BOJ - 근손실 (18429)

</details>
<details>
<summary>
3주차 - 백트래킹, BFS/DFS(1) ✓
</summary>

- BOJ - 암호 만들기 (1759)
- BOJ - 로또 (6603)
- BOJ - 계란으로 계란치기 (16987) <br><br>

- BOJ - 알고리즘 수업 - 깊이 우선탐색 1 (24479)
- BOJ - 알고리즘 수업 - 너비 우선탐색 1 (24444)
- BOJ - 숨바꼭질 (1697) 
- BOJ - 물통 (2251) 
- BOJ - 토마토 (7659)

</details>

<details>
<summary>
4주차 - BFS/DFS(2), 역량테스트 A형 대비문제 🗓
</summary>
</details>
<details>
<summary>
5주차 - Git 정리 및 📃보고서 작성<br> 
</summary>
</details>


# 📃 Git 폴더 규칙
문서는 항상 다음과 같이 관리합시다. <br>
<b>1. Workspace는 자유롭게 설정하되, Git에는 `각자 이름` 폴더로 묶어서 올립시다.</b> <br><br>
~~<b>2. 📁패키지명은 아래와 같이 통일합시다.</b><br>~~
~~백준 : `com.baekjoon.주제`<br>~~
~~프로그래머스 : `com.programmers.주제`~~ <br><br>
<b>2. 📁패키지명은 자유자제로 합시다. </b><br>
```
Workspace : C:\Algorithm_study
Folder Name : [👨각자 이름] - [📁src] - [📁com.baekjoon.문제주제] - [📃Baekjoon_1234.java]...

↓ 자유 패키지로 변경.

Workspace : C:\Algorithm_study
Folder Name : [👨각자 이름] - [📁자유 패키지] - [📃Main.java]...
```
<b>3. 항상 src 폴더만 Git에 업로드합시다.</b> ex) git add src로 해주세요 😊<br>
⚠️ <b>[📁bin]</b> 업로드 금지!     
~~git pull 안하신거 티나요👀..~~ <br><br>
4. <b>branch는 그대로 `master`에서 진행합니다.</b><br>
# 🛫 Git 사용법 간단정리

⚡ <b>본인 내용</b>만 수정하셔야 합니다!! (충돌나요..)⚡<br />
<h5>✔1. Git 원격지 주소 추가 (한번만 진행해주세요.)</h5>

``` bash
# Usage : git remote add [원격저장소 별명] [원격저장소 주소]

ex)
git remote add origin https://github.com/SSAFY-EWSNN/Algorithm_study.git
```

<h5>✔2. Git 파일 추적해서 내용 최신화(git pull)</h5>

``` bash
# Usage : git remote add [원격저장소 별명] [브랜치]

ex) 
git pull origin master
```

<h5>✔3. Git 파일 추가</h5>

``` bash
# Usage : git add [추가할 파일/폴더]

ex) 현재 폴더 기준으로 모두 추가
git add . 또는 git add *

ex) 특정 폴더/파일 추가

[workspace] ─┬─ [📁mwkim] ─┬── [🗄️1.java]
             │              └── [🗄️2.java]
             └─ [🗄️other.java]

# mwkim 폴더 내 하위 내용 모두 추가
git add mwkim

# other.java만 추가
git add other.java
```

<h5>✔4. Git에 스테이지 된 내용 확인</h5>

``` bash
git status

# git status 실행 내용.

# 현재 브랜치.
On branch master

# 현재 어느 원격지에 어떤 브랜치 스테이지 시키는 지 확인.
Your branch is up to date with 'origin/master'.

# 아직 git add를 안한 파일 보여줌. 
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   README.md

# 추적 안하는 파일.
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .project

no changes added to commit (use "git add" and/or "git commit -a")
```

<h5>✔5. Commit</h5>

``` bash
# Usage: git commit -m '커밋 메세지'
# 왠만하면 본인이 한 내용을 커밋 메세지로 올려주세요.
git commit -m '얏호 코딩 끝났다💻'
```

<h5>✔6. Push</h5>

⚠️ <b>절대 git push -f로 push 하지 마세요.</b> 깃 꼬입니다.. 😥😣⚠️<br/>
~~관리자가 뿔나요. 👿~~
<br/><br />
<b>push가 왜 안 될까🤔</b> 하는 경우 말씀해주세요. 
``` bash
# Usage: git push -u [원격지 별명] [원격지 브랜치]
git push -u origin master
```

# 이거 웨 않돼요?🤔 (FAQ)

1. Github Token 문제
- 해결법 찾아보고 올리겠습니다. 😥

2. git add *(혹은 or)를 해도 스테이징이 안 되는 경우.<br>
→ git add -A 입력해주세요.
```
git add -A
```

3. 사고치면 알려주세여... 🥶
