# 🏝️ 싸피에서 살아남기

<b>Member : 👨‍💻성우, 👨‍💻민우, 👩‍💻슬기, 👩‍💻정언, 👩‍💻희진</b><br/><br/>
Git 관리는 <a href="https://github.com/mccreate"><b>👨‍💻민우</b></a>가 할게요.

<br/><br/><br/>


# Git 사용법 간단정리🛫

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

는 곧 추가할게요. 😊
