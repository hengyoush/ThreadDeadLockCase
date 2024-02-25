git config --global --add safe.directory /home/coder/project
git config --global user.email "you@example.com"
git config --global user.name "you"
git add --all
git commit -m "commit"
GITHUB_USER=$1
GITHUB_TOKEN=$2
export git_url=$(git remote get-url --push origin) \
&&  echo "git push $git_url" | sed -e "s|https://|https://$GITHUB_USER:$GITHUB_TOKEN@|" | sh

