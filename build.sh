git config --global --add safe.directory /home/coder/project
git config --global user.email "hengyoush1@163.com"
git config --global user.name "hengyoush"

GITHUB_USER=$1
GITHUB_TOKEN=$2
GITHUB_BRANCH=$3

current_branch=$(git rev-parse --abbrev-ref HEAD)
if [ "$current_branch" != "$GITHUB_BRANCH" ]; then
  git checkout -B "$GITHUB_BRANCH"
fi

git add --all
git commit -m "commit"
export git_url=$(git remote get-url --push origin) \
&&  echo "git push $git_url $GITHUB_BRANCH:$GITHUB_BRANCH" | sed -e "s|https://|https://$GITHUB_USER:$GITHUB_TOKEN@|" | sh

