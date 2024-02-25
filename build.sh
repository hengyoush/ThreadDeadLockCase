git config --global --add safe.directory /home/coder/project
git config --global user.email "you@example.com"
git config --global user.name "you"
git add --all
git commit -m "commit"
export git_username=$GITHUB_USER && export git_url=$(git remote get-url --push origin) \
&& export github_token=$GITHUB_TOKEN  \
&&  echo "git push $git_url" | sed -e "s|https://|https://$git_username:$github_token@|" | sh

