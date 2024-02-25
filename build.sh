git config --global --add safe.directory /home/coder/project
git config --global user.email "you@example.com"
git config --global user.name "you"
git add --all
git commit -m "commit"
export git_username=hengyoush && export git_url=$(git remote get-url --push origin) \
&& export github_token=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  \
&&  echo "git push $git_url" | sed -e "s|https://|https://$git_username:$github_token@|" | sh

