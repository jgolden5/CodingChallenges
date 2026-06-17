#Rock, Paper, Scissors
def rps(p1, p2):
  moves = {
    #maps moves losing to winning
    "rock": "paper",
    "paper": "scissors",
    "scissors": "rock"
  }
  if moves[p1] == p2:
    winning_message = 'Player 2 won!'
  elif moves[p2] == p1:
    winning_message = 'Player 1 won!'
  else:
    winning_message = 'Draw!'
  return winning_message

rps('paper', 'scissors')
